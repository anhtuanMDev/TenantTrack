package com.example.tenanttrack.data.local.entities

import androidx.annotation.StringRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tenanttrack.R

@Entity
data class RoomTable(
    @PrimaryKey(autoGenerate = true) val uid: Int,
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

enum class RoomAmenities(@StringRes val displayName: Int) {
    // General
    AC(R.string.amenities_ac),
    HEATING(R.string.amenities_heating),
    WIFI(R.string.amenities_wifi),
    TV(R.string.amenities_tv),
    WASHER(R.string.amenities_washer),
    DRYER(R.string.amenities_dryer),
    IRON(R.string.amenities_iron),
    HAIR_DRYER(R.string.amenities_hair_dryer),
    CLOSET(R.string.amenities_closet),
    WORK_DESK(R.string.amenities_work_desk),
    BALCONY(R.string.amenities_balcony),
    FIREPLACE(R.string.amenities_fireplace),

    // Kitchen
    REFRIGERATOR(R.string.amenities_refrigerator),
    STOVE(R.string.amenities_stove),
    OVEN(R.string.amenities_oven),
    MICROWAVE(R.string.amenities_microwave),
    DISHWASHER(R.string.amenities_dishwasher),
    ELECTRIC_KETTLE(R.string.amenities_electric_kettle),
    COFFEE_MAKER(R.string.amenities_coffee_maker),
    TOASTER(R.string.amenities_toaster),
    KITCHEN_UTENSILS(R.string.amenities_kitchen_utensils),
    DINING_TABLE(R.string.amenities_dining_table),
    COOKING_BASICS(R.string.amenities_cooking_basics),

    // Bedroom
    BED_LINENS(R.string.amenities_bed_linens),
    EXTRA_BLANKETS(R.string.amenities_extra_blankets),
    BLACKOUT_CURTAINS(R.string.amenities_blackout_curtains),
    NIGHTSTAND(R.string.amenities_nightstand),

    // Bathroom
    TOWELS(R.string.amenities_towels),
    SHAMPOO(R.string.amenities_shampoo),
    BODY_SOAP(R.string.amenities_body_soap),
    TOILET_PAPER(R.string.amenities_toilet_paper),
    HOT_WATER(R.string.amenities_hot_water),
    BATHTUB(R.string.amenities_bathtub),
    SHOWER(R.string.amenities_shower),

    // Building
    ELEVATOR(R.string.amenities_elevator),
    SECURITY_SYSTEM(R.string.amenities_security_system),
    CONCIERGE(R.string.amenities_concierge),
    GYM(R.string.amenities_gym),
    SWIMMING_POOL(R.string.amenities_swimming_pool),
    GARDEN(R.string.amenities_garden),
    PLAYGROUND(R.string.amenities_playground),
    ROOFTOP(R.string.amenities_rooftop),
    LAUNDRY_ROOM(R.string.amenities_laundry_room),
    COMMON_AREA(R.string.amenities_common_area),

    // Parking
    FREE_PARKING(R.string.amenities_free_parking),
    PAID_PARKING(R.string.amenities_paid_parking),
    STREET_PARKING(R.string.amenities_street_parking),
    EV_CHARGER(R.string.amenities_ev_charger),
    BIKE_STORAGE(R.string.amenities_bike_storage),
    SHUTTLE_SERVICE(R.string.amenities_shuttle_service),

    // Pet / Family
    PET_FRIENDLY(R.string.amenities_pet_friendly),
    CRIB(R.string.amenities_crib),
    HIGH_CHAIR(R.string.amenities_high_chair),
    TOYS(R.string.amenities_toys),
    SAFETY_GATES(R.string.amenities_safety_gates),

    // Business / Tech
    HIGH_SPEED_INTERNET(R.string.amenities_high_speed_internet),
    ETHERNET(R.string.amenities_ethernet),
    PRINTER(R.string.amenities_printer),
    WORKSPACE(R.string.amenities_workspace),

    // Outdoor
    PRIVATE_ENTRANCE(R.string.amenities_private_entrance),
    PATIO(R.string.amenities_patio),
    OUTDOOR_FURNITURE(R.string.amenities_outdoor_furniture),
    BBQ_GRILL(R.string.amenities_bbq_grill),
    FIRE_PIT(R.string.amenities_fire_pit),
    YARD(R.string.amenities_yard),

    // Safety
    SMOKE_DETECTOR(R.string.amenities_smoke_detector),
    CO_DETECTOR(R.string.amenities_co_detector),
    FIRST_AID_KIT(R.string.amenities_first_aid_kit),
    FIRE_EXTINGUISHER(R.string.amenities_fire_extinguisher),
    SECURITY_CAMERAS(R.string.amenities_security_cameras);
}
