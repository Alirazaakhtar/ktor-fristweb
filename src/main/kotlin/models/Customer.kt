import kotlinx.serialization.Serializable


///DB
val customerDB = mutableListOf(Customer("1", "Ali"))

@Serializable
data class Customer(val id: String?, val name: String?)

