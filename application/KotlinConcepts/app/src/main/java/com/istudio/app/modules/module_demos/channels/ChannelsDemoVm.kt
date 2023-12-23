package com.istudio.app.modules.module_demos.channels

import android.widget.TextView.BufferType
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ChannelsDemoVm @Inject constructor( ) : ViewModel() {

    // <! ------------------- COMMUNICATING BETWEEN COROUTINES ------------------->
    // A channel of languages
    private var languageChannel = Channel<Languages>()

    /**
     * Sending and receiving only one value
     */
    fun simpleCommunication() {

        // Co-Routine - 1
        viewModelScope.launch {
            languageChannel.send(Languages.English)
        }

        // Co-Routine - 2
        viewModelScope.launch {
            println(languageChannel.receive())
        }

    }

    /**
     * Sending and receiving multiple values
     */
    fun sendingMultipleValues() {

        // Co-Routine - 1
        viewModelScope.launch {
            languageChannel.send(Languages.English)
            languageChannel.send(Languages.Hindi)
            languageChannel.send(Languages.French)
        }

        // Co-Routine - 2
        viewModelScope.launch {
            languageChannel.consumeEach {
                println(languageChannel.receive())
            }
        }

    }


    /**
     * Canceling a channel
     */
    fun cancellingChannel() {

        // Co-Routine - 1
        viewModelScope.launch {
            println("Sending value - 1")
            languageChannel.send(Languages.English)
            println("Sending value - 2")
            languageChannel.send(Languages.Hindi)
            println("Sending value - 3")
            languageChannel.send(Languages.French)
        }

        // Co-Routine - 2
        viewModelScope.launch {
            try {
                println(languageChannel.receive())
                languageChannel.cancel(CancellationException("Custom Exception"))
                println(languageChannel.receive())
                println(languageChannel.receive())
            }catch (ex : Exception){
                println(ex.message)
                println("Is it closed for Send: -> "+languageChannel.isClosedForSend)
                println("Is it closed for Receive: -> "+languageChannel.isClosedForReceive)
            }
        }

    }


    /**
     * Closing a channel
     */
    fun closingChannel() {

        // Co-Routine - 1
        viewModelScope.launch {
            languageChannel.send(Languages.English)
            languageChannel.close()
            languageChannel.send(Languages.Hindi)
            languageChannel.send(Languages.French)

        }

        // Co-Routine - 2
        viewModelScope.launch {
            languageChannel.consumeEach {
                println(languageChannel.receive())
            }
        }

    }

    enum class Languages { English , Hindi , French }

    // <! ------------------- COMMUNICATING BETWEEN COROUTINES ------------------->


    // <! ------------------- USING PRODUCE IN CHANNELS -------------------------->

    private var receiveChannel : ReceiveChannel<Superheroes> = Channel()

    fun usingProduce() {

        // Co-Routine - 1
        viewModelScope.launch {
            receiveChannel = produce {
                send(Superheroes.Batman)
                send(Superheroes.Superman)
                send(Superheroes.Spiderman)
            }
        }

        // Co-Routine - 2
        viewModelScope.launch {
            println("Is closed to receive -->"+ receiveChannel.isClosedForReceive)
            receiveChannel.consumeEach { superHero ->
                println(superHero)
            }
            println("Is closed to receive -->"+ receiveChannel.isClosedForReceive)
        }

    }

    enum class Superheroes { Batman , Superman , Spiderman }
    // <! ------------------- USING PRODUCE IN CHANNELS -------------------------->


    // <! ------------------- USING CHANNELS - BUFFERED -------------------------->
    private var receiveBufferChannel : ReceiveChannel<Countries> = Channel()

    fun usingBuffered() {
        // Co-Routine - 1
        viewModelScope.launch {

            // We are limiting the buffer capacity to 2
            receiveBufferChannel = produce(capacity = 2) {
                    println("Send Action : ----> USA")
                    send(Countries.USA)
                    println("Send Action : ----> Russia")
                    send(Countries.Russia)
                    println("Send Action : ----> India")
                    send(Countries.India)
                    println("Send Action : ----> France")
                    send(Countries.France)
                    println("Send Action : ----> Spain")
                    send(Countries.Spain)
                    println("Send Action : ----> Germany")
                    send(Countries.Germany)
                    println("Send Action : ----> Italy")
                    send(Countries.Italy)
            }

        }

        // Co-Routine - 2
        viewModelScope.launch {
            receiveBufferChannel.consumeEach { countries ->
                println("Receive Action : ----> $countries")
                println("---------------------------------")
            }
        }
    }

    enum class Countries { USA , Russia , India , France , Spain , Germany , Italy }

    // <! ------------------- USING CHANNELS - BUFFERED -------------------------->

    // <! ------------------- USING CHANNELS - CONFLATED-------------------------->
    private var receiveConflatedChannel : ReceiveChannel<Birds> = Channel()

    fun usingConflated() {
        // Co-Routine - 1
        viewModelScope.launch {

            receiveConflatedChannel = produce(capacity = CONFLATED) {
                send(Birds.Eagle)
                send(Birds.Peacock)
                send(Birds.Robin)
                send(Birds.Ostrich)
                send(Birds.Pigeon)
                send(Birds.Kingfisher)
                send(Birds.Dodo)
            }

        }

        // Co-Routine - 2
        viewModelScope.launch {
            receiveConflatedChannel.consumeEach { birds ->
                println("BIRD : ----> $birds")
            }
        }
    }

    enum class Birds { Eagle , Peacock , Robin , Ostrich , Pigeon , Kingfisher , Dodo }

    // <! ------------------- USING CHANNELS - CONFLATED-------------------------->

    // <! ------------------- USING CHANNELS - RENDEZVOUS-------------------------->
    private var receiveRendezvousChannel : ReceiveChannel<Cars> = Channel()

    fun usingRendezvous() {
        // Co-Routine - 1
        viewModelScope.launch {

            receiveRendezvousChannel = produce {
                println("SENT : ----> ${Cars.Maruthi}")
                send(Cars.Maruthi)
                println("SENT : ----> ${Cars.BMW}")
                send(Cars.BMW)
                println("SENT : ----> ${Cars.Tesla}")
                send(Cars.Tesla)
                println("SENT : ----> ${Cars.Byd}")
                send(Cars.Byd)
                println("SENT : ----> ${Cars.TATA}")
                send(Cars.TATA)
                println("SENT : ----> ${Cars.Ferrari}")
                send(Cars.Ferrari)
                println("SENT : ----> ${Cars.Porshe}")
                send(Cars.Porshe)
            }

        }

        // Co-Routine - 2
        viewModelScope.launch {
            println("CAR : ----> ${receiveRendezvousChannel.receive()}")
            println("CAR : ----> ${receiveRendezvousChannel.receive()}")
            println("CAR : ----> ${receiveRendezvousChannel.receive()}")
        }
    }

    enum class Cars { Maruthi , BMW , Tesla , Byd , TATA , Ferrari , Porshe }

    // <! ------------------- USING CHANNELS - RENDEZVOUS-------------------------->

    // <! ------------------- USING CHANNELS - RENDEZVOUS-------------------------->
    private var receiveUnlimitedChannel : ReceiveChannel<Cars> = Channel()

    fun usingUnlimited() {
        // Co-Routine - 1
        viewModelScope.launch {

            receiveUnlimitedChannel = produce(capacity = UNLIMITED) {
                println("SENT : ----> ${Cars.Maruthi}")
                send(Cars.Maruthi)
                println("SENT : ----> ${Cars.BMW}")
                send(Cars.BMW)
                println("SENT : ----> ${Cars.Tesla}")
                send(Cars.Tesla)
                println("SENT : ----> ${Cars.Byd}")
                send(Cars.Byd)
                println("SENT : ----> ${Cars.TATA}")
                send(Cars.TATA)
                println("SENT : ----> ${Cars.Ferrari}")
                send(Cars.Ferrari)
                println("SENT : ----> ${Cars.Porshe}")
                send(Cars.Porshe)
            }

        }

        // Co-Routine - 2
        viewModelScope.launch {
            println("CAR : ----> ${receiveUnlimitedChannel.receive()}")
            println("CAR : ----> ${receiveUnlimitedChannel.receive()}")
            println("CAR : ----> ${receiveUnlimitedChannel.receive()}")
        }
    }
    // <! ------------------- USING CHANNELS - UNLIMITED-------------------------->
}