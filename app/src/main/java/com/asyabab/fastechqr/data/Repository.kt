package com.asyabab.fastechqr.data


import android.content.Context
import com.asyabab.fastechqr.data.local.SharedPrefHelper
import com.asyabab.fastechqr.data.models.general.GeneralResponse
import com.asyabab.fastechqr.data.network.APIRequest


import java.io.File
import java.util.*

class Repository(private val mContext: Context) {

    private val apiRequest: APIRequest = APIRequest()

    private val prefs: SharedPrefHelper = SharedPrefHelper(mContext)
    fun versionCodeCheck(
        callback: GeneralResponse.GeneralResponseCallback
    ) {
        apiRequest.versionCodeCheck(callback)
    }
    fun savenama(
        id: String,
        callback: GeneralResponse.GeneralResponseCallback
    ) {
        apiRequest.savenama(id, callback)
    }
//    private var mProfile = Profile()
//    private var city = ArrayList<String>()
//    private var spesialis = ArrayList<String>()

//    fun signUp(email: String, password: String, callback: SignUpResponse.SignUpResponseCallback) {
//        apiRequest.signUp(email, password, callback)
//    }
//
//    fun getCity(token: String, email: String, callback: CityResponse.CityResponseCallback) {
//        apiRequest.getCity(token, email, callback)
//    }
//
//    fun getSpesialis(
//        token: String,
//        email: String,
//        callback: SpesialisResponse.SpesialisResponseCalback
//    ) {
//        apiRequest.getSpesialis(token, email, callback)
//    }
//
//    fun login(email: String, uid: String, callback: LoginResponse.LoginResponseCallback) {
//        apiRequest.login(email, uid, callback)
//    }
//
//    fun saveDokterFavorit(token: String, email: String, kodedokter: String, callback: GeneralResponse.GeneralResponseCallback) {
//        apiRequest.saveDokterFavorit(token, email, kodedokter, callback)
//    }
//
//    fun getDokterFavorit(
//        token: String,
//        email: String,
//        callback: DokterFavoritListResponse.DokterFavoritListResponseCallback
//    ) {
//        apiRequest.getDokterFavorit(token, email, callback)
//    }
//
//
//    fun saveProfile(profile: Profile) {
//        mProfile = profile
//    }
//
//    fun getProfile(): Profile {
//        return mProfile
//    }
//
//    fun changeUserPhoto(
//        token: String,
//        email: String,
//        file: File,
//        callback: ProfileUpdateResponse.ProfileUpdateResponseCallback
//    ) {
//        apiRequest.changeUserPhoto(token, email, file, callback)
//    }
//
//    fun updateUserProfile(
//        profile: Profile,
//        token: String,
//        callback: ProfileUpdateResponse.ProfileUpdateResponseCallback
//    ) {
//        apiRequest.updateUserProfile(profile, token, callback)
//    }
//
//    fun getDoctorList(
//        token: String,
//        email: String,
//        callback: DoctorListResponse.DoctorListResponseCallback
//    ) {
//        apiRequest.getDoctorList(token, email, callback)
//    }
//
//    fun searchDoctor(
//        token: String,
//        email: String,
//        kota: String,
//        sp: String,
//        callback: DoctorListResponse.DoctorListResponseCallback
//    ) {
//        apiRequest.searchDoctor(token, email, kota, sp, callback)
//    }
//
//    fun getDoctorDetail(
//        token: String,
//        email: String,
//        uid: String,
//        callback: DoctorDetailResponse.DoctorDetailResponseCallback
//    ) {
//        apiRequest.getDoctorDetail(token, email, uid, callback)
//    }
//
//    fun getDoctorDetail2(
//        token: String,
//        email: String,
//        username: String,
//        callback: DoctorDetailResponse.DoctorDetailResponseCallback
//    ) {
//        apiRequest.getDoctorDetail2(token, email, username, callback)
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
//        apiRequest.requestChat(token, email, uid, kodechat, callback)
//    }
//
//    fun cancelRequestChat(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.cancelRequestChat(token, email, uid, kodechat, callback)
//    }
//
//    fun endChat(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.endChat(token, email, uid, kodechat, callback)
//    }
//
//    fun getAccountNumber(
//        token: String,
//        email: String,
//        uid: String,
//        callback: AccountNumberResponse.AccountNumberResponseCallback
//    ) {
//        apiRequest.getAccountNumber(token, email, uid, callback)
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
//        apiRequest.uploadInvoice(
//            token, email, uid, kodechat,
//            rekdokter, daribank, atasnama,
//            jumlah, note, foto,
//            callback
//        )
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
//        apiRequest.sendReview(token, email, uid, kodechat, rate, tell, callback)
//    }
//
//    fun loadProfile(
//        token: String,
//        email: String,
//        url: String,
//        callback: ProfileResponse.ProfileResponseCallback
//    ) {
//        apiRequest.loadProfile(token, email, url, callback)
//    }
//
//    fun getArticle(token: String, email: String, callback: ArticleResponse.ArticleResponseCalback) {
//        apiRequest.getArticle(token, email, callback)
//    }
//
//
//    fun getAllArticle(
//        token: String,
//        email: String,
//        callback: ArticleResponse.ArticleResponseCalback
//    ) {
//        apiRequest.getAllArticle(token, email, callback)
//    }
//
//    fun searchArticle(
//        token: String,
//        email: String,
//        query: String,
//        callback: ArticleResponse.ArticleResponseCalback
//    ) {
//        apiRequest.searchArticle(token, email, query, callback)
//    }
//
//    fun getArticleDetail(
//        token: String,
//        email: String,
//        link: String,
//        callback: ArticleResponse.ArticleResponseCalback
//    ) {
//        apiRequest.getArticleDetail(token, email, link, callback)
//    }
//
//    fun getPaymentList(
//        token: String,
//        email: String,
//        callback: PaymentListResponse.PaymentListResponseCallback
//    ) {
//        apiRequest.getPaymentList(token, email, callback)
//    }
//
//    fun getPhotoUser(
//        token: String,
//        email: String,
//        callback: PhotoResponse.PhotoResponseCallback
//    ) {
//        apiRequest.getPhotoUser(token, email, callback)
//    }
//
//    fun getAccountDetail(
//        token: String,
//        email: String,
//        callback: EditProfileResponse.EditProfileResponseCallback
//    ) {
//        apiRequest.getAccountDetail(token, email, callback)
//    }
//
//    fun getKecamatan(
//        token: String,
//        email: String,
//        kabupaten: String,
//        callback: KecamatanResponse.KecamatanResponseCallback
//    ) {
//        apiRequest.getKecamatan(token, email, kabupaten, callback)
//    }
//
//    fun saveEditProfile(
//        token: String,
//        email: String,
//        profile: Profile2,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.saveEditProfile(token, email, profile, callback)
//    }
//
//    fun getRecenChat(
//        token: String,
//        email: String,
//        callback: RecentChatResponse.RecentChatResponseCallback
//    ) {
//        apiRequest.getRecenChat(token, email, callback)
//    }
//
//    fun getAdviceList(
//        token: String,
//        email: String,
//        callback: AdviceListResponse.AdviceListResponseCallback
//    ) {
//        apiRequest.getAdviceList(token, email, callback)
//    }
//
//    fun downloadReceipt(
//        token: String,
//        email: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.downloadReceipt(token, email, kodechat, callback)
//    }
//
//    fun downloadList(
//        token: String,
//        email: String,
//        kodechat: String,
//        callback: DownloadListResponse.DownloadListResponseCallback
//    ) {
//        apiRequest.downloadList(token, email, kodechat, callback)
//    }
//    fun getMedicaldata(
//        token: String,
//        email: String,
//        callback: MedicalDataResponse.MedicalDataResponseCallback
//    ) {
//        apiRequest.getMedicaldata(token, email, callback)
//    }
//
//    fun saveMedicalData(
//        token: String,
//        email: String,
//        medicalData: pasien.ruangpraktek.data.models.medical_data.Profile,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.saveMedicalData(token, email, medicalData, callback)
//    }
//
//    fun getBadge(
//        token: String,
//        email: String,
//        callback: BadgeResponse.BadgeResponseCallback
//    ) {
//        apiRequest.getBadge(token, email, callback)
//    }
//
//    fun getPersonInCharge(
//        token: String,
//        email: String,
//        callback: PersonInChargeResponse.PersonInChargeResponseCallback
//    ) {
//        apiRequest.getPersonInCharge(token, email, callback)
//    }
//
//    fun savePersonInCharge(
//        token: String,
//        email: String,
//        uid: String,
//        profile: Data,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.savePersonInCharge(token, email, uid, profile, callback)
//    }
//
//    fun getPasienRawat(
//        token: String,
//        email: String,
//        callback: HospitalizedPatientResponse.HospitaledPatientResponseCallback
//    ) {
//        apiRequest.getPasienRawat(token, email, callback)
//    }
//

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
//        apiRequest.addAppointment(token, email, uid, kodechat, tgl, jam, ket, callback)
//    }
//
//    fun getAppointmentList(
//        token: String,
//        email: String,
//        callback: AppointmentListResponse.AppointmenListResponseCallback
//    ) {
//        apiRequest.getAppointmentList(token, email, callback)
//    }
//
//    fun cancelAppointment(
//        token: String,
//        email: String,
//        kodechat: String,
//        alasan: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.cancelAppointment(token, email, kodechat, alasan, callback)
//    }
//
//    fun submitSelfAssesment(
//        token: String,
//        email: String,
//        kodechat: String,
//        jawaban: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.submitSelfAssesment(token, email, kodechat, jawaban, callback)
//    }
//
//    fun checkChatFee(
//        token: String,
//        email: String,
//        uid: String,
//        kodechat: String,
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.checkChatFee(token, email, uid, kodechat, callback)
//    }
//
//    fun versionCodeCheck(
//        callback: GeneralResponse.GeneralResponseCallback
//    ) {
//        apiRequest.versionCodeCheck(callback)
//    }
//
//    fun cekData(token: String, email: String, jsonObject2: JSONObject) {
//        apiRequest.cekData(token, email, jsonObject2)
//    }
//    fun setFirstTimeLaunch(isFirstTime: Boolean) {
//        prefs.setFirstTimeLaunch(isFirstTime)
//    }
//
//    fun isFirstTimeLaunch(): Boolean {
//        return prefs.isFirstTimeLaunch()
//    }
//
//    fun saveCurrentUID(token: String?) {
//        prefs.putString(SharedPrefHelper.ACCES_UID_DOCTOR, token!!)
//    }
//
//    fun getCurrentUID(): String? {
//        return prefs.getString(SharedPrefHelper.ACCES_UID_DOCTOR)
//    }
//
//    fun saveToken(token: String?) {
//        prefs.putString(SharedPrefHelper.ACCES_TOKEN, token!!)
//    }
//
//    fun getToken(): String? {
//        return prefs.getString(SharedPrefHelper.ACCES_TOKEN)
//    }
//
//    fun logOut() {
//        prefs.clear()
//    }
//
//    fun checkEmail(email: String, callback: GeneralResponse.GeneralResponseCallback) {
//        apiRequest.checkEmail(email, callback)
//    }
//
//    fun saveCity(listKabupaten: ArrayList<String>) {
//        city = listKabupaten
//    }
//
//    fun getCity(): ArrayList<String> {
//        return city
//    }
//
//    fun saveSpesialis(list: ArrayList<String>?) {
//        if (list != null) {
//            spesialis = list
//        }
//    }
//
//    fun getSpesialis(): ArrayList<String> {
//        return spesialis
//    }
//
//    fun downloadFile(
//        url: String,
//        dirPath: String,
//        fileName: String,
//        callback: DownloadFileResponse.DownloadFileResponseCallback
//    ) {
//        apiRequest.downloadFile(url, dirPath, fileName, callback)
//    }
}