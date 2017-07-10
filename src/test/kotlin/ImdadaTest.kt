import cn.imdada.ImDadaApi
import cn.imdada.ImDadaClientBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/10
 * 微信: yin80871901
 */

fun main(args: Array<String>) {
//    val objectMapper = ObjectMapper().registerModule(KotlinModule())
//    val api = ImDadaClientBuilder("dadad8ef7b50fee58c6", "2941465b94f63a3a4276804fcce91bdd")
//            .jsonMapper(objectMapper)
//            .enableProd(false)
//            .build()

    // api.addOrder("73753", )

    val http = OkHttpClient.Builder().build()

    val payload = "{\"app_key\":\"dadad8ef7b50fee58c6\",\"signature\":\"6AEF06AED5D4972913BCB70467E02559\",\"timestamp\":\"1499681185\",\"format\":\"json\",\"v\":\"1.0\",\"source_id\":\"73753\",\"body\":\"{\\\"shop_no\\\":\\\"11047059\\\",\\\"origin_id\\\":\\\"20170710100002054\\\",\\\"city_code\\\":\\\"0571\\\",\\\"cargo_price\\\":0.0,\\\"is_prepay\\\":0,\\\"expected_fetch_time\\\":1499681484,\\\"receiver_name\\\":\\\"尹昶胜\\\",\\\"receiver_address\\\":\\\"浙江省杭州市滨江区火炬大道三维大厦11楼1106室\\\",\\\"receiver_lat\\\":30.281027,\\\"receiver_lng\\\":120.07898,\\\"callback\\\":\\\"http://openapi.qurenjia.com/imdada/callback?event_form=newdada\\\",\\\"receiver_phone\\\":\\\"13575762817\\\",\\\"receiver_tel\\\":\\\"\\\",\\\"tips\\\":0.0,\\\"pay_for_supplier_fee\\\":5.0,\\\"fetch_from_receiver_fee\\\":0.0,\\\"deliver_fee\\\":0.0,\\\"create_time\\\":1499681184,\\\"info\\\":\\\"微辣\\\",\\\"cargo_type\\\":1,\\\"cargo_weight\\\":0.4,\\\"cargo_num\\\":2,\\\"expected_finish_time\\\":1499683284,\\\"invoice_title\\\":null,\\\"deliver_locker_code\\\":null,\\\"pickup_locker_code\\\":null,\\\"origin_mark\\\":\\\"YinTaoHuo\\\",\\\"origin_mark_no\\\":\\\"4\\\"}\"}"

    val req = Request.Builder()
            .url("http://newopen.qa.imdada.cn/api/order/addOrder")
            .post(RequestBody.create(MediaType.parse("application/json"), payload)).build()

    val resp = http.newCall(req).execute()

    val bd = resp.body()

    println(bd?.string())

}

