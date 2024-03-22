import java.lang.IllegalArgumentException
import java.util.*
import kotlin.math.abs

const val PI = 3.14159
fun main(args: Array<String>) {
    println("HomeWork 1")
    val pageNo=11// Change this value to see the result of the corresponding page
    when(pageNo){
        11 -> println(functionsAndVariables(3))
        12 -> startCar()
        14 -> stringExample("Oğuz","Gökçen",22)
        15 -> println(ternaryExample("oguzgok21@gmail.com"))
        16,82 -> forExample()
        17,83 -> whileExample(3)
        18 -> println(whenExample("Car"))
        19,85 -> rangeExample(10)
        20 -> collectionExample()
        21 -> nullSafetyExample(null)
        22,55,80 -> println(typeCheckExample(4.38))
        32,33 -> propertExample("Oğuz","Gökçen",22)
        34,35,56 -> controlFlowStatementsExample(-3,-4)
        37,38,90,91 -> dataClassExample()
        39,40,41,42,43,44 -> idomsExample()
        47 -> Logger.log("Value of pi is: $PI")
        48 -> abstractClassExample()
        49,50,53 -> notNullCheckExample(null)
        51 -> emptyCheckExample(mapOf("name" to "Oğuz","surname" to "Gökçen"))
        52 -> getFirstItem(listOf())
        58 -> println(getWheelCount("MotorCycle"))
        59 -> println(arrayOfcharacter('s',5))
        61 -> flyAPlane()
        62 -> println(createPerson("Oğuz","Gökçen").userId)
        64 -> getEmployeeTypeExample()
        65 -> changeVariable()
        66 -> todoFunc()
        68 -> exponentiateExample()
        69 -> operatorOverloadingExample()
        70 -> varArgExample(200,201,202,500,400,401).forEach { println(it) }
        75 -> addItemsToBox()
        76 -> swap()
        77 -> inheritenceExample()
        78,79 -> createComputer()
        else -> println("Not implemented")
    }
}

fun functionsAndVariables(radius:Int):Double{
    println("Sayfa 11")
    val diameter = radius * 2
    val circumReference:Double
    circumReference = calculateCircumference(diameter, PI)
    return circumReference

}

fun calculateCircumference(diameter:Int, pi:Double):Double{
    val circumference = diameter * pi
    return circumference
}

//"------------Sayfa 12,13-------------"

open class Vehicle{
    val color = "White"
    open fun start(){
        println("Vehicle is starting")
    }
}
class Car:Vehicle(){
    override fun start(){
        println("Car is starting color:${color}")
    }
}

fun startCar(){
    println("Sayfa 12,13")
    val car = Car()
    car.start()
}

//"------------Sayfa 14,30-------------"
fun stringExample(
    nameOfTheStudent:String,
    surnameOfTheStudent:String,
    ageOfTheStudent:Int
):Unit{
    println("Sayfa 14")
    val message = "My name is $nameOfTheStudent and my surname is ${surnameOfTheStudent.uppercase(Locale.forLanguageTag("tr"))} I am $ageOfTheStudent years old"
    println(message)
}

//"------------Sayfa 15,31-------------"

fun ternaryExample(email:String) = if('@' in email) "valid" else "invalid"

//"------------Sayfa 16-------------"

fun forExample(){
    println("Sayfa 16")
    val vehicleList = listOf("araba","otobüs","minibüs")
    for (item in vehicleList){
        println(item)
    }
}

//"------------Sayfa 17-------------"

fun whileExample(treeLenght:Int){
    println("Sayfa 17")
    if(treeLenght<0){
        println("Insert positive number!")
        return
    }
    var counter = 1;
    while (counter < treeLenght*2){
        println(" ".repeat(treeLenght-counter/2)+"*".repeat(counter))
        counter++
        counter++
    }
}

//"------------Sayfa 18-------------"

fun whenExample(vehicle:String):String{
    println("Sayfa 18")
    return when (vehicle) {
        "Car" -> "Four-wheeler"
        "Motorcycle" -> "Two-wheeler"
        "Truck" -> "Heavy vehicle"
        else -> "Unknown vehicle type"
    }
}

//"------------Sayfa 19-------------"
//string parrametre

fun rangeExample(y: Int){
    println("Sayfa 19")
    val range = 1..5
    for (i in range){
        print("$i ")
    }
    println()
    for (x in y downTo 0 step 3){
        print("$x ")
    }
}

//"------------Sayfa 20-------------"
//Koleksiyonlar

fun collectionExample(){
    println("Sayfa 20")
    val vehicleList = listOf("araba","otobüs","minibüs")
    println(vehicleList.filter { it.length > 5 })
}

//"------------Sayfa 21-------------"
//null safety

fun nullSafetyExample(name:String?){
    println("Sayfa 21")
    println(name)
    if (name != null){
        println(name)
    }else{
        println("Name is null")
    }
}

//"------------Sayfa 22,55-------------"

fun typeCheckExample(a:Any):String{
    println("Sayfa 22,55")
    return when (a){
        is String ->"$a"
        is Int -> a.toString()
        is Double -> String.format("%.2f", a)
        is Float -> String.format("%.2f", a)
        else -> a.toString()
    }
}

//"------------Sayfa 32,33-------------"

fun propertExample(x:String, y:String, z:Int) =
    createPersonWithValidMailAndID(x,y)

fun createPersonWithValidMailAndID(x:String,y:String){
    val person = Person()
    person.name = x
    person.surname = y
    println(person.userId)
    println(person.surname)
}
class Person{
    var name:String = ""
        get()= field
        set(value){
            field = value.lowercase(Locale.forLanguageTag("tr"))
        }
    var surname:String = ""
        get() = field
        set(value){
            field = value.uppercase(Locale.forLanguageTag("tr"))
        }
    val userId:String
        get() = name +"_"+ surname
}

//"------------Sayfa 34,35,56-------------"

fun controlFlowStatementsExample(speedCar1:Int,speedCar2:Int) {
    println("Sayfa 34,35")
    if (speedCar1 > speedCar2 &&
        speedCar1 > 0 &&
        speedCar2 > 0
    ) {
        println("Car 1 is faster than Car 2 and both are moving positive way")
    }
    if (speedCar1 < 0) {
        println("Car 1 is moving in the opposite direction")
    } else if (speedCar2 < 0) {
        println("Car 2 is moving in the opposite direction")
    } else {
        println("Both cars are moving in the same direction")
    }

    try {
        println("Car 1 is moving ${if(speedCar2 !=0) abs(speedCar1.toDouble()) / abs(speedCar2.toDouble()) else throw java.lang.ArithmeticException("Division by zero")} times faster than Car 2")
    } catch (e: ArithmeticException) {
        println("Sayfa 56")
        println("Car 2 is not moving")
    }
    finally {
        println("Function is completed")
    }
}

//"------------Sayfa 37,90,91-------------"

data class User(val name:String,val surname:String,val email:String,val emailConfirmed :Boolean = false)

fun dataClassExample(){
    println("Sayfa 37,90,91")
    val User1 = User("Oğuz","Gökçen","abc@gmail.com")
    val User2 = User("Oğuz","Gökçen","abc@gmail.com")
    println("person1 == person2: ${User1 == User2}")
    println("person1 email confirmed: ${User1.emailConfirmed}")
    val User3 = User1.copy(emailConfirmed = true)
    println("person3 email confirmed: ${User3.emailConfirmed}")


}

//"------------Sayfa 39-46-------------"

fun String.toUppercaseTr():String{
    return this.uppercase(Locale.forLanguageTag("tr"))
}
fun idomsExample(){
    println("Sayfa 39-44")
    val names = listOf("Ali","Vecdi","Ayşe","Hasan","Elif")
    println(names.filter {it.startsWith("A")})
    println(if ("Hasan" in names) "Hasan is in the list" else "Hasan is not in the list")
    val days = mapOf("Monday" to 1,"Tuesday" to 2,"Wednesday" to 3,"Thursday" to 4,"Friday" to 5,"Saturday" to 6,"Sunday" to 7)
    for ((key,value) in days){
        println("$key is the $value. day of the week")
    }
    val name:String by lazy {
        println("Name is initialized")
        "Oğuz"
    }
    println(name)
    println(name.toUppercaseTr())
}

//"------------Sayfa 47-------------"

object Logger{
    init {
        println("Sayfa 47\nLogger is initialized")
    }
    fun log(message:String){
        println(message)
    }
}

//"------------Sayfa 48-------------"
val BASE_SALARY = 1000
abstract class Employee(val name: String, val id: Int) {
    abstract fun work()
    abstract fun calculateSalary(): Double

    fun displayDetails() {
        println("Name: $name, ID: $id")
    }
}

class Manager(name: String,id: Int) : Employee(name,id) {
    override fun work() {
        println("Manager is working")
    }

    override fun calculateSalary(): Double {
        return BASE_SALARY * 2.5
    }
}

fun abstractClassExample(){
    println("Sayfa 48")
    val manager = Manager("John", 100)
    manager.work()
    manager.displayDetails()
    println("Manager's salary: ${manager.calculateSalary()}")
}

//"------------Sayfa 49,50,53-------------"

fun notNullCheckExample(list:List<String>?){
    println("Sayfa 49,50,53")
    println(list?.size ?:0)

    list?.let {
        for (item in it){
            println(item)
        }
    }
}

//"------------Sayfa 51-------------"

fun emptyCheckExample(map: Map<String,String>){
    println("Sayfa 51")
    val phoneNumber = map["PhoneNumber"]?: "No phone number"
    println(phoneNumber)

}

//"------------Sayfa 52-------------"

fun getFirstItem(list:List<String>){
    println(list.firstOrNull()?:"No item found")
}

//"------------Sayfa 58-------------"

fun getWheelCount(vehicle:String):Int{
    println("Sayfa 58")
    return if (vehicle == "Car"){
        4
    } else if (vehicle == "MotorCycle"){
        2
    }else{
        throw IllegalArgumentException("Unknown vehicle type")
    }
}

//"------------Sayfa 59-------------"

fun arrayOfcharacter(char:Char,size:Int): CharArray {
    println("Sayfa 59")
    return CharArray(size).apply { fill(char) }
}

//"------------Sayfa 61-------------"

class Plane{
    fun startEngine(){
        println("Engine is starting")
    }
    fun pullTheNose(degrees:Double){
        println("Plane is pulling the nose $degrees degrees")
    }
    fun fly(){
        println("Plane is flying")
    }
}

//"------------Sayfa 61-------------"

fun flyAPlane(){
    println("Sayfa 61")
    val plane = Plane()
    plane.startEngine()
    plane.pullTheNose(30.0)
    plane.fly()
}

//"------------Sayfa 62-------------"

fun createPerson(nameOfPerson:String,surnameOfPerson:String):Person{
    println("Sayfa 62")
    val person = Person().apply {
        name = nameOfPerson
        surname = surnameOfPerson
    }
    return person
}

//"------------Sayfa 64-------------"

inline fun <reified T> getEmployeeType(value:T){
    val type = T::class.simpleName
    println("Type of the Employee is $type")
}

fun getEmployeeTypeExample(){
    println("Sayfa 64")
    getEmployeeType(Manager("John",100))
}
//"------------Sayfa 65-------------"

fun changeVariable(){
    println("Sayfa 65")
    var names = listOf("AYŞE","ALİ","VELİ","HASAN","ELİF")
    names = names.also {
        println("Names are $it")

        println(it.filter { it.startsWith("A") })
    }
}

//"------------Sayfa 66-------------"

fun todoFunc():Unit = TODO()

//"------------Sayfa 68-------------"

infix fun Int.exponentiate(x:Int):Int = Math.pow(this.toDouble(),x.toDouble()).toInt()
fun exponentiateExample(){
    println("Sayfa 68")
    println(2 exponentiate 3)
}

//"------------Sayfa 69-------------"
data class Triangle(val h:Int,val t:Int)
operator fun Triangle.inc()= Triangle(h+1,t+1)
fun operatorOverloadingExample(){
    println("Sayfa 69")
    var triangle = Triangle(3,4)
    println(triangle)
    triangle++
    println(triangle)
}

//"------------Sayfa 70-------------"

fun varArgExample(vararg numbers:Int):List<Int>{
    println("Sayfa 70")
    //returns unsuccesfull http responsers
    return numbers.filter { !it.toString().startsWith("2")}
}

//"------------Sayfa 75-------------"

class Box<T>(var item: T) {
    fun getItemFromBox(): T {
        return item
    }

    fun putItemToBox(newItem: T) {
        item = newItem
    }
}
fun addItemsToBox(){
    println("Sayfa 75")
    val box = Box(5)
    println(box.getItemFromBox())
    box.putItemToBox(10)
    println(box.getItemFromBox())
}

//"------------Sayfa 76-------------"

fun <T> swap(list: MutableList<T>, index1: Int, index2: Int) {
    val temp = list[index1]
    list[index1] = list[index2]
    list[index2] = temp
}

fun swap() {
    println("Sayfa 76")
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    println("Before swap: $numbers") // Output: Before swap: [1, 2, 3, 4, 5]

    swap(numbers, 1, 3)

    println("After swap: $numbers") // Output: After swap: [1, 4, 3, 2, 5]
}

//"------------Sayfa 77-------------"

fun inheritenceExample(){
    println("Sayfa 77")
    val vehicle:Vehicle = Car()
    vehicle.start()
}

//"------------Sayfa 78,79-------------"

open class Computer(val name:String,val price:Int,val type:String){
    open fun description(){
        println("$name is priced at $price and it is a $type")
    }
}

class Laptop(name:String,price:Int):Computer(name,price,"Laptop"){
    override fun description(){
        println("$name is priced at $price and it is a $type")
    }
}

fun createComputer(){
    println("Sayfa 78")
    val computer = Laptop("Dell",5000)
    computer.description()
}

//
