
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule


data class Message(
    val messageId: Long,
    @field:JsonFormat(with = [JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY]) val recipient: List<String>
)

fun main() {
    val sample = "{\"messageId\": 1, \"recipient\": \"tadashiya@test.com\"}"
    val sample2 = "{\"messageId\": 1, \"recipient\": [\"tadashiya@test.com\", \"tadashiya2@test.com\"]}"
    val objectMapper = ObjectMapper().registerKotlinModule()

    println("Hello Kotlin!!")
    println(objectMapper.readValue(sample, Message::class.java)) // Message(messageId=1, recipient=[tadashiya@test.com])
    println(objectMapper.readValue(sample2, Message::class.java)) // Message(messageId=1, recipient=[tadashiya@test.com, tadashiya2@test.com])
}
