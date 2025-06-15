package com.example.tenanttrack.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomTable(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "property_id") val propertyID: Int,
    val name: String,
    val floor: String,
    val sqr: Int,
    val amenities: List<RoomAmenities>,
    @ColumnInfo(name = "rent_at") val rentAt: Int,
    @ColumnInfo(name = "paid_at") val paidAt: Int,
    val status: RoomStatus,
    @ColumnInfo(name = "available_from") val availableFrom: Int,
    @ColumnInfo(name = "rent")val rentMoney: Int,
    val furnished: Boolean,
)

enum class RoomStatus {
    Active,
    Pending,
    Vacant,
    Maintain
}

enum class RoomAmenities(val displayName: String) {
    // General
    AC("Air Conditioning"),
    HEATING("Heating"),
    WIFI("Wi-Fi"),
    TV("TV"),
    WASHER("Washer"),
    DRYER("Dryer"),
    IRON("Iron / Ironing board"),
    HAIR_DRYER("Hair Dryer"),
    CLOSET("Closet / Wardrobe"),
    WORK_DESK("Work Desk"),
    BALCONY("Balcony / Terrace"),
    FIREPLACE("Fireplace"),

    // Kitchen
    REFRIGERATOR("Refrigerator"),
    STOVE("Stove / Cooktop"),
    OVEN("Oven"),
    MICROWAVE("Microwave"),
    DISHWASHER("Dishwasher"),
    ELECTRIC_KETTLE("Electric Kettle"),
    COFFEE_MAKER("Coffee Maker"),
    TOASTER("Toaster"),
    KITCHEN_UTENSILS("Kitchen Utensils"),
    DINING_TABLE("Dining Table"),
    COOKING_BASICS("Cooking Basics"),

    // Bedroom
    BED_LINENS("Bed Linens"),
    EXTRA_BLANKETS("Extra Pillows and Blankets"),
    BLACKOUT_CURTAINS("Blackout Curtains"),
    NIGHTSTAND("Nightstand / Lamp"),

    // Bathroom
    TOWELS("Towels"),
    SHAMPOO("Shampoo / Conditioner"),
    BODY_SOAP("Body Soap"),
    TOILET_PAPER("Toilet Paper"),
    HOT_WATER("Hot Water"),
    BATHTUB("Bathtub"),
    SHOWER("Shower"),

    // Building
    ELEVATOR("Elevator"),
    SECURITY_SYSTEM("Security System"),
    CONCIERGE("Concierge / Doorman"),
    GYM("Gym / Fitness Center"),
    SWIMMING_POOL("Swimming Pool"),
    GARDEN("Garden"),
    PLAYGROUND("Playground"),
    ROOFTOP("Rooftop Access"),
    LAUNDRY_ROOM("Laundry Room"),
    COMMON_AREA("Common Area / Lounge"),

    // Parking
    FREE_PARKING("Free Parking on Premises"),
    PAID_PARKING("Paid Parking"),
    STREET_PARKING("Street Parking"),
    EV_CHARGER("EV Charger"),
    BIKE_STORAGE("Bicycle Storage"),
    SHUTTLE_SERVICE("Shuttle Service"),

    // Pet / Family
    PET_FRIENDLY("Pet Friendly"),
    CRIB("Crib"),
    HIGH_CHAIR("High Chair"),
    TOYS("Children’s Books or Toys"),
    SAFETY_GATES("Baby Safety Gates"),

    // Business / Tech
    HIGH_SPEED_INTERNET("High-Speed Internet"),
    ETHERNET("Ethernet Connection"),
    PRINTER("Printer / Scanner"),
    WORKSPACE("Laptop-Friendly Workspace"),

    // Outdoor
    PRIVATE_ENTRANCE("Private Entrance"),
    PATIO("Patio / Deck"),
    OUTDOOR_FURNITURE("Outdoor Furniture"),
    BBQ_GRILL("BBQ Grill"),
    FIRE_PIT("Fire Pit"),
    YARD("Garden / Yard"),

    // Safety
    SMOKE_DETECTOR("Smoke Detector"),
    CO_DETECTOR("Carbon Monoxide Detector"),
    FIRST_AID_KIT("First Aid Kit"),
    FIRE_EXTINGUISHER("Fire Extinguisher"),
    SECURITY_CAMERAS("Security Cameras");

    override fun toString(): String = displayName
}
