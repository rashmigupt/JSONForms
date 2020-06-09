package com.example.samplemoneyloji.view.services


import com.example.samplemoneyloji.Field
import org.json.JSONArray
import org.json.JSONObject

object APICall {

    fun signIn(listKey:List<Field>,listValue:List<String>) {
        var requestArr = JSONArray()
        for (i in 0..listKey.size-1) {
            val request = JSONObject()
            request.put("id", listKey[i].id)
            request.put("text", listValue[i])
            requestArr.put(request)
        }

        var request:JSONObject=JSONObject()
        request!!.put("data",requestArr)

        // hit Api here...
      // initCall(OKClient.POST, APIFunctions.signin, request.toString(), listener)
    }
     /* private fun initCall(
           apiType: Int,
           url: String,
           body: String,
           listener: ApiResultListener
       ) {
           try {
               OKClient.initCall(apiType, url, body, server)
                   .subscribeBy(
                       onSuccess = { response ->
                           validateResponse(response, listener).subscribeBy(
                               onSuccess = { response ->
                                   initCall(apiType, url, body, server, listener)
                               }, onError = {
                                   val error = "" + it.localizedMessage
                                   logTechEvent(url, error, error)
                               }
                           )
                       }, onError = {
                           val error = "" + it.localizedMessage
                           logTechEvent(url, "" + error, "" + error)
                           listener.onFail(error)
                       }
                   )
           } catch (e: Throwable) {
               val error = "" + e.localizedMessage
               logTechEvent(url, error, "" + error)
               return listener.onFail("Error $error")
           }
       }*/
}