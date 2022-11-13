package com.asyabab.invitate.data.network

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.asyabab.invitate.data.models.general.GeneralResponse
import com.google.gson.GsonBuilder
import org.json.JSONObject

/**
 */

class APIRequest {
    companion object {
//        val BASE_URL_WEBVIEW = "10.10.10.100/fastech/android/"
        //        val BASE_URL_WEBVIEW = "https://webview.ruangpraktek.id"

    }

    private val BASE_URL = "https://192.168.43.2/fastech/android/"
//    private val BASE_URL = "https://api.ruangpraktek.id/dokter/"

    private val TAG = "hasil"
    private val gson = GsonBuilder().create()
    private var requestUrl = ""



//    enum class ErrorCode {
//        NOT_FOUND,
//        NO_INTERNET,
//        SERVER_ERROR
//    }

    fun versionCodeCheck(
        callback: GeneralResponse.GeneralResponseCallback
    ) {

        requestUrl = BASE_URL + "cekversi.php"
//        Log.e(TAG, "onResponse: $requestUrl")

        AndroidNetworking.get(requestUrl)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG,"onResponse: $response"+" "+token)

                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
                    if (response1 != null) {
                        callback.onSuccess(response1)
                    } else {
                        callback.onFailure("Cannot get Object")
                    }
                }

                override fun onError(anError: ANError) {
                    callback.onFailure(anError.errorBody)
                }
            })
    }
    fun savenama(
        id: String,

        callback: GeneralResponse.GeneralResponseCallback
    ) {
        requestUrl = BASE_URL + "kirimnama.php"
//        Log.e(TAG, "onResponse: $requestUrl")

        AndroidNetworking.post(requestUrl)
            .addBodyParameter("id_undangan", id)

            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e(TAG, "onResponse: $response")

                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
                    if (response1 != null) {
                        callback.onSuccess(response1)
                    } else {
                        callback.onFailure("Cannot get Object")
                    }
                }

                override fun onError(anError: ANError) {
                    callback.onFailure(anError.errorBody)
                }
            })
    }
}
////    fun signUp(email: String, password: String, callback: SignUpResponse.SignUpResponseCallback) {
////
////        requestUrl = BASE_URL + "account/register"
//////        Log.e(TAG, "onResponse: $requestUrl")
////
////        AndroidNetworking.post(requestUrl)
////            .addBodyParameter("email", email)
////            .addBodyParameter("password", password)
////            .setPriority(Priority.MEDIUM)
////            .build()
////            .getAsJSONObject(object : JSONObjectRequestListener {
////                override fun onResponse(response: JSONObject) {
//////                    Log.e(TAG,"onResponse: $response")
////
////                    val response1 = gson.fromJson(response.toString(), SignUpResponse::class.java)
////                    if (response1 != null) {
////                        callback.onSuccess(response1)
////                    } else {
////                        callback.onFailure("Cannot get Object")
////                    }
////                }
////
////                override fun onError(anError: ANError) {
////                    callback.onFailure(anError.errorBody)
////                }
////            })
////    }
//
//    fun login(email: String, uid: String, callback: LoginResponse.LoginResponseCallback) {
//        requestUrl = BASE_URL + "account/login"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("email", email)
//            .addBodyParameter("uid", uid)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), LoginResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getCity(token: String, email: String, callback: CityResponse.CityResponseCallback) {
//
//        requestUrl = BASE_URL + "data/domisili"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 = gson.fromJson(response.toString(), CityResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getSpesialis(
//        token: String,
//        email: String,
//        callback: SpesialisResponse.SpesialisResponseCalback
//    ) {
//
//        requestUrl = BASE_URL + "data/spesialis"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), SpesialisResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun changeUserPhoto(
//        token: String,
//        email: String,
//        file: File,
//        callback: ProfileUpdateResponse.ProfileUpdateResponseCallback
//    ) {
//        requestUrl = BASE_URL + "account/fotoawal"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.upload(requestUrl)
//            .addMultipartFile("foto", file)
//            .addMultipartParameter("token", token)
//            .addMultipartParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response")
//                    val response1 =
//                        gson.fromJson(response.toString(), ProfileUpdateResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                    Log.e(TAG, "onResponse: ${anError.errorBody}")
//                }
//            })
//    }
//
//    fun updateUserProfile(
//        profile: Profile,
//        token: String,
//        callback: ProfileUpdateResponse.ProfileUpdateResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "account/profileawal"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", profile.email)
//            .addBodyParameter("nama", profile.nama)
//            .addBodyParameter("nik", profile.nik)
//            .addBodyParameter("telp", profile.telp)
//            .addBodyParameter("kelamin", profile.kelamin)
//            .addBodyParameter("tempat", profile.tempat)
//            .addBodyParameter("lahir", profile.lahir)
//            .addBodyParameter("alamat", profile.alamat)
//            .addBodyParameter("kabupaten", profile.kabupaten)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), ProfileUpdateResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    Log.e(TAG, "onResponse: ${anError.errorBody}")
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getDoctorList(
//        token: String,
//        email: String,
//        callback: DoctorListResponse.DoctorListResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/listdokter"
//        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response" + " " + token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), DoctorListResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                    Log.e("hasil", anError.toString())
//                }
//            })
//    }
//
//    fun searchDoctor(
//        token: String,
//        email: String,
//        kota: String,
//        sp: String,
//        callback: DoctorListResponse.DoctorListResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "data/caridokter"
//        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .addQueryParameter("kota", kota)
//            .addQueryParameter("sp", sp)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), DoctorListResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                    Log.e("hasil", anError.errorBody)
//                }
//            })
//    }
//
//    fun getDoctorDetail(
//        token: String,
//        email: String,
//        uid: String,
//        callback: DoctorDetailResponse.DoctorDetailResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "data/detaildokter"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .addQueryParameter("uid", uid)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response" + " " + token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), DoctorDetailResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getDoctorDetail2(
//        token: String,
//        email: String,
//        username: String,
//        callback: DoctorDetailResponse.DoctorDetailResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "data/detailusername"
//        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .addQueryParameter("username", username)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response $token")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), DoctorDetailResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//
//    fun requestChat(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/reqchat"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("uid", uid)
//            .addBodyParameter("kodechat", kodechat)
//            .setPriority(Priority.HIGH)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun cancelRequestChat(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/cancelreqchat"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("uid", uid)
//            .addBodyParameter("kodechat", kodechat)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun endChat(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/endchat"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("uid", uid)
//            .addBodyParameter("kodechat", kodechat)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//
//    fun getAccountNumber(
//        token: String,
//        email: String,
//        uid: String,
//        callback: AccountNumberResponse.AccountNumberResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "data/rekeningdokter"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .addQueryParameter("uid", uid)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response" + " " + token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), AccountNumberResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                    Log.e("hasil", anError.toString())
//                }
//            })
//    }
//
//    fun uploadInvoice(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        rekdokter: String,
//        daribank: String,
//        atasnama: String,
//        jumlah: String,
//        note: String,
//        foto: File,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/uploadbukti"
//        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.enableLogging()
//
//        AndroidNetworking.upload(requestUrl)
//            .addHeaders("Content-Type", "multipart/form-data")
//            .addMultipartParameter("token", token)
//            .addMultipartParameter("email", email)
//            .addMultipartParameter("uid", uid)
//            .addMultipartParameter("kodechat", kodechat)
//            .addMultipartParameter("rekdokter", rekdokter)
//            .addMultipartParameter("daribank", daribank)
//            .addMultipartParameter("atasnama", atasnama)
//            .addMultipartParameter("jumlah", jumlah)
//            .addMultipartParameter("note", note)
//            .addMultipartFile("foto", foto)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                    Log.e(TAG, "onError: ${anError.message}")
//                    Log.e(TAG, "onError: $anError")
//                }
//            })
//    }
//
//    fun sendReview(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        rate: String,
//        tell: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/ratechat"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("uid", uid)
//            .addBodyParameter("kodechat", kodechat)
//            .addBodyParameter("rate", rate)
//            .addBodyParameter("tell", tell)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun loadProfile(
//        token: String,
//        email: String,
//        url: String,
//        callback: ProfileResponse.ProfileResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "data/$url"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 = gson.fromJson(response.toString(), ProfileResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getArticle(token: String, email: String, callback: ArticleResponse.ArticleResponseCalback) {
//
//        requestUrl = BASE_URL + "data/artikel"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 = gson.fromJson(response.toString(), ArticleResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getAllArticle(
//        token: String,
//        email: String,
//        callback: ArticleResponse.ArticleResponseCalback
//    ) {
//
//        requestUrl = BASE_URL + "data/allartikel"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 = gson.fromJson(response.toString(), ArticleResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun searchArticle(
//        token: String,
//        email: String,
//        query: String,
//        callback: ArticleResponse.ArticleResponseCalback
//    ) {
//
//        requestUrl = BASE_URL + "data/cariartikel"
//        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .addQueryParameter("query", query)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response" + " " + token)
//
//                    val response1 = gson.fromJson(response.toString(), ArticleResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getArticleDetail(
//        token: String,
//        email: String,
//        link: String,
//        callback: ArticleResponse.ArticleResponseCalback
//    ) {
//
//        requestUrl = BASE_URL + "data/detailartikel"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .addQueryParameter("link", link)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response" + " " + token)
//
//                    val response1 = gson.fromJson(response.toString(), ArticleResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getPaymentList(
//        token: String,
//        email: String,
//        callback: PaymentListResponse.PaymentListResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/recentpayment"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), PaymentListResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//
//    fun getAccountDetail(
//        token: String,
//        email: String,
//        callback: EditProfileResponse.EditProfileResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/editprofile"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), EditProfileResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getKecamatan(
//        token: String,
//        email: String,
//        kabupaten: String,
//        callback: KecamatanResponse.KecamatanResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/kecamatan"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("email", email)
//            .addQueryParameter("token", token)
//            .addQueryParameter("kabupaten", kabupaten)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), KecamatanResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getRecenChat(
//        token: String,
//        email: String,
//        callback: RecentChatResponse.RecentChatResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/recentcommunication"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), RecentChatResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//
//    fun getAdviceList(
//        token: String,
//        email: String,
//        callback: AdviceListResponse.AdviceListResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/notes"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), AdviceListResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//
//    fun getMedicaldata(
//        token: String,
//        email: String,
//        callback: MedicalDataResponse.MedicalDataResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/datamedis"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), MedicalDataResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun saveMedicalData(
//        token: String,
//        email: String,
//        medicalData: com.asyabab.fastechqr.data.models.medical_data.Profile,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/savedatamedis"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("berat", medicalData.berat)
//            .addBodyParameter("goldar", medicalData.goldar)
//            .addBodyParameter("diabet", medicalData.diabet)
//            .addBodyParameter("haemo", medicalData.haemo)
//            .addBodyParameter("jantung", medicalData.jantung)
//            .addBodyParameter("riwayat", medicalData.riwayat)
//            .addBodyParameter("alobat", medicalData.alobat)
//            .addBodyParameter("almakanan", medicalData.almakanan)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun saveEditProfile(
//        token: String,
//        email: String,
//        profile: Profile2,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/saveprofile"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("nama", profile.nama)
//            .addBodyParameter("nik", profile.nik)
//            .addBodyParameter("tempat", profile.tempat)
//            .addBodyParameter("lahir", profile.lahir)
//            .addBodyParameter("kabupaten", profile.kabupaten)
//            .addBodyParameter("kecamatan", profile.kecamatan)
//            .addBodyParameter("alamat", profile.alamat)
//            .addBodyParameter("telp", profile.telp)
//            .addBodyParameter("kelamin", profile.kelamin)
//            .addBodyParameter("nikah", profile.nikah)
//            .addBodyParameter("pekerjaan", profile.pekerjaan)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun downloadReceipt(
//        token: String,
//        email: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "data/downloadreceipt"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .addQueryParameter("kodechat", kodechat)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun downloadList(
//        token: String,
//        email: String,
//        kodechat: String,
//        callback: DownloadListResponse.DownloadListResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "data/downloadlist"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .addQueryParameter("kodechat", kodechat)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), DownloadListResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun checkEmail(email: String, callback: GeneralResponse.GeneralResponseCallback) {
//
//        requestUrl = BASE_URL + "account/cekemail"
//        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    Log.e("hasil", anError.errorBody)
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getPhotoUser(
//        token: String,
//        email: String,
//        callback: PhotoResponse.PhotoResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/editfoto"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), PhotoResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getBadge(
//        token: String,
//        email: String,
//        callback: BadgeResponse.BadgeResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/badge"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), BadgeResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getPersonInCharge(
//        token: String,
//        email: String,
//        callback: PersonInChargeResponse.PersonInChargeResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/datattd"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), PersonInChargeResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun savePersonInCharge(
//        token: String,
//        email: String,
//        uid: String,
//        profile: Data,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/pasienttd"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("uid", uid)
//            .addBodyParameter("nama", profile.nama)
//            .addBodyParameter("alamat", profile.alamat)
//            .addBodyParameter("lahir", profile.lahir)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun getPasienRawat(
//        token: String,
//        email: String,
//        callback: HospitalizedPatientResponse.HospitaledPatientResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/oranglain"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 =
//                        gson.fromJson(response.toString(), HospitalizedPatientResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun savePasienRawat(
//        token: String,
//        email: String,
//        uid: String,
//        profile: PostOrang,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/pasienconsent"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("uid", uid)
//            .addBodyParameter("kodechat", profile.kodechat)
//            .addBodyParameter("idpasien", profile.id.toString())
//            .addBodyParameter("pasien", profile.pasien)
//            .addBodyParameter("nama", profile.nama)
//            .addBodyParameter("kelamin", profile.kelamin)
//            .addBodyParameter("relasi", profile.relasi)
//            .addBodyParameter("lahir", profile.lahir)
//            .addBodyParameter("alamat", profile.alamat)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//

//
//    fun getDokterFavorit(
//        token: String,
//        email: String,
//        callback: DokterFavoritListResponse.DokterFavoritListResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/favorit"
//
//        Log.e(TAG, "onResponse: $requestUrl")
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response" + " " + token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), DokterFavoritListResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                    Log.e("hasil", anError.toString())
//                }
//            })
//
//    }
//
//    fun getAppointmentList(
//        token: String,
//        email: String,
//        callback: AppointmentListResponse.AppointmenListResponseCallback
//    ) {
//        requestUrl = BASE_URL + "data/listappointment"
//        Log.e(TAG, "onResponse: $requestUrl")
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response" + " " + token)
//
//                    val response1 =
//                        gson.fromJson(response.toString(), AppointmentListResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                    Log.e("hasil", anError.toString())
//                }
//            })
//
//    }
//
//    fun addAppointment(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        tgl: String,
//        jam: String,
//        ket: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/reqappointment"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("uid", uid)
//            .addBodyParameter("kodechat", kodechat)
//            .addBodyParameter("tgl", tgl)
//            .addBodyParameter("jam", jam)
//            .addBodyParameter("ket", ket)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun cancelAppointment(
//        token: String,
//        email: String,
//        kodechat: String,
//        alasan: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/cancelappointment"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("kode", kodechat)
//            .addBodyParameter("alasan", alasan)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//
//    fun submitSelfAssesment(
//        token: String,
//        email: String,
//        kodechat: String,
//        jawaban: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        requestUrl = BASE_URL + "save/submitselfassestment"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.post(requestUrl)
//            .addBodyParameter("token", token)
//            .addBodyParameter("email", email)
//            .addBodyParameter("kodechat", kodechat)
//            .addBodyParameter("jawaban", jawaban)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e(TAG, "onResponse: $response")
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//    fun downloadFile(
//        url: String,
//        dirPath: String,
//        fileName: String,
//        callback: DownloadFileResponse.DownloadFileResponseCallback
//    ) {
//        Log.e("downloadFile", url)
//        AndroidNetworking.download(url, dirPath, fileName)
//            .setTag("downloadTest")
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .setDownloadProgressListener { bytesDownloaded, totalBytes ->
//                // do anything with progress  asd
//                callback.onProgress(bytesDownloaded, totalBytes)
//            }
//            .startDownload(object : DownloadListener1 {
//                override fun onDownloadComplete() {
//                    callback.onSuccess(fileName, dirPath)
//                }
//
//                override fun onError(anError: ANError?) {
//                    callback.onFailure(anError?.errorDetail)
//                }
//
//            })
//    }
//
//
//    fun checkChatFee(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//
//        requestUrl = BASE_URL + "data/cekchatfg"
////        Log.e(TAG, "onResponse: $requestUrl")
//
//        AndroidNetworking.get(requestUrl)
//            .addQueryParameter("token", token)
//            .addQueryParameter("email", email)
//            .addQueryParameter("uid", uid)
//            .addQueryParameter("kodechat", kodechat)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
////                    Log.e(TAG,"onResponse: $response"+" "+token)
//
//                    val response1 = gson.fromJson(response.toString(), GeneralResponse::class.java)
//                    if (response1 != null) {
//                        callback.onSuccess(response1)
//                    } else {
//                        callback.onFailure("Cannot get Object")
//                    }
//                }
//
//                override fun onError(anError: ANError) {
//                    callback.onFailure(anError.errorBody)
//                }
//            })
//    }
//
//

//
//
//    fun cekData(token: String, email: String, jsonObject2: JSONObject) {
//        val onlineHours = OnlineHours()
//        onlineHours.jam.add("08.00-16.00")
//        onlineHours.jam.add("24 jam")
//        onlineHours.online = true
//
//        val jsonInString = gson.toJson(onlineHours)
//        val tempJsonObject: JSONObject?
//        val jsonObject = JSONObject()
//        val jsonObject2 = JSONObject()
//        try {
//            tempJsonObject = (JSONObject(jsonInString))
//            jsonObject.put("senin", tempJsonObject)
//            jsonObject.put("selasa", tempJsonObject)
//            jsonObject.put("rabu", tempJsonObject)
//            jsonObject.put("kamis", tempJsonObject)
//            jsonObject2.put("token", "ini token")
//            jsonObject2.put("email", "ini email")
//            jsonObject2.put("jam_buka", jsonObject)
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        requestUrl = BASE_URL + "save/savejambuka"
//        Log.e(TAG, "onResponse: $jsonObject2")
//        AndroidNetworking.enableLogging()
//        AndroidNetworking.post(requestUrl)
//            .setTag("hasil")
//            .addJSONObjectBody(jsonObject2)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//
//                }
//
//                override fun onError(anError: ANError) {
//                }
//            })
//    }
//}
//
