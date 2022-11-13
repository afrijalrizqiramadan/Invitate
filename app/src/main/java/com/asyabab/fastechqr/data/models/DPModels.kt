package pasien.ruangpraktek.data.models

import java.io.Serializable

data class Notiffications(
    var date: String = "",
    var kode_chat: String = "",
    var receiver_id: String = "",
    var receiver_name: String = "",
    var request_id: String = "",
    var sender_id: String = "",
    var sender_name: String = "",
    var time: String = "",
    var type: String = ""
)

data class roomChat(
    var uid: String? = null,
    var nama: String? = null,
    var hours: String? = null,
    var experience: String? = null,
    var rating: Int? = null,
    var price: String? = null,
    var userimage: String? = null
)

data class Task(
    var heading: String? = null,
    var subheading: String? = null,
    var active: Boolean? = false
)

data class User(
    var name: String? = null,
    var img: Int? = null,
    var flag: Int? = null,
    var isSelected: Boolean? = false
)

data class Collections(
    var name: String? = null,
    var description: String? = null,
    var option: String? = null,
    var isSelected: Boolean? = false
)

data class Questions(
    var Questions: String? = null,
    var total: Int? = null
)

data class Consults(
    var name: String? = null,
    var doctorName: String? = null,
    var durations: String? = null,
    var status: String? = null,
    var date: String? = null,
    var flag: Int? = null,
    var userimage: Int? = null,
    var icon: Int? = null,
    var statuscolor: Int? = null

) : Serializable

data class OnlineConsult(
    var name: String? = null,
    var info: String? = null,
    var cost: String? = null
)

data class AvailableTeam(
    var doctorName: String? = null,
    var conditionName: String? = null,
    var rating: String? = null,
    var review: String? = null,
    var address: String? = null,
    var userimage: Int? = null
)

data class AvailableTeams(
    var doctorName: String? = null,
    var online: String? = null,
    var hours: String? = null,
    var experience: String? = null,
    var rating: String? = null,
    var price: String? = null,
    var userimage: Int? = null
)

data class Specialist(
    var name: String? = null,
    var icon: Int? = null
)

data class Attachments(
    var name: String? = "",
    var durations: String? = "",
    var img: String? = ""
)

data class Health(
    var name: String? = null,
    var info: String? = null,
    var img: Int? = null
)

class chat {
    var msg: String? = null
    var isSender: Boolean = false
    var type: String? = null
    var img: Int? = null
    var duration: String? = null

}

data class Card(
    var code: String? = null,
    var doctorName: String? = null,
    var bankNo: String? = null,
    var amount: String? = null,
    var img: Int? = null
)

data class SearchTradingTopic(
    var Name: String? = null,
    var Topicimg: Int? = null,
    var doctorImg: Int? = null,
    var doctorName: String? = null
)

data class searchSpecialist(
    var name: String? = null,
    var icon: Int? = null,
    var flag: Int? = null
)

data class Conditions(
    var name: String? = null,
    var icon: Int? = null,
    var background: Int? = null
)

data class Hospital(
    var HospitalName: String? = null,
    var rating: String? = null,
    var mile: String? = null,
    var review: String? = null,
    var address: String? = null,
    var HospitalImg: Int? = null
)

data class HealthInfo(
    var type: String? = null,
    var value: String? = null,
    var info: String? = null,
    var share: String? = null,
    var doctorName: String? = null,
    var status: String? = null,
    var img: Int? = null,
    var flag: Int? = null,
    var doctorImg: Int? = null
)

data class Family(
    var name: String? = null,
    var other: String? = null,
    var info: String? = null,
    var img: Int? = null
)

data class FamilyMedical(
    var name: String? = null,
    var count: String? = null,
    var img: Int? = null,
    var flag: Int? = null
)

data class Condition(
    var name: String? = null,
    var time: String? = null,
    var info: String? = null
)

data class Review(
    var name: String? = null,
    var rating: String? = null,
    var description: String? = null,
    var img: Int? = null,
    var time: String? = null
)

data class Question(
    var doctorName: String? = null,
    var conditionName: String? = null,
    var rating: String? = null,
    var review: String? = null,
    var doctorimage: Int? = null,
    var image: Int? = null,
    var description: String? = null,
    var agree: String? = null
)

data class Doctor(
    var doctorName: String? = null,
    var conditionName: String? = null,
    var rating: String? = null,
    var review: String? = null,
    var doctorimage: Int? = null
)

class Users {
    var device_token: String? = null
    var email: String? = null
    var is_typing: Boolean? = null
    var login_time: String? = null
    var logout_time: String? = null
    var name: String? = null
    var state: String? = null
    var status: String? = null
    var request_id: String? = null
    var user_type: String? = null
    var kode_chat: String? = null

}

class Keywords(
    var name: String? = null
)
