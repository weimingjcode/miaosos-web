/*
package com.miaosos.utils;

import java.util.HashMap;
import java.util.Set;

import com.cloopen.rest.sdk.CCPRestSDK;

public class RongLianSmsUtil {
	private final static String URL = "sandboxapp.cloopen.com";
	private final static String PORT = "8883";
	private final static String ACCOUNT_SID = "8a48b55149896cfd0149a7a824c5167c";
	private final static String AUTH_TOKEN = "6ad9de7758664f24b180cca729d6e325";
	private final static String APP_ID = "8a48b5514a4d9532014a50b9b1b60091";
	// public static final String KE_FU_1_SUCCESS_ID = "168558";
	// public static final String KE_FU_2_SUCCESS_ID = "168560";

	*/
/**
	 * 【法视云综合救援】{1}您好！秒帮用户{2}，当前在{3}附近发出紧急求助报险信息，
	 * 请速登录秒帮手机客户端查看处理险情，法视云客服：4008779595。
	 *//*

	public final static String SHOU_XIN_REN_TONG_ZHI_ID = "174529";
	*/
/**
	 * 【法视云综合救援】您填写的个人信息不完善，设备报险功能无法使用，请您及时在秒帮手机客户端完善个人信息，谢谢！
	 *//*

	public final static String FU_WU_ZHONG_DUAN_ID = "169469";
	*/
/**
	 * 【法视云综合救援】尊贵的主人，您已经使用了{1}次报险试用的机会了，还有{2}次试用机会喔，感谢您的试用，祝您生活愉快
	 *//*

	public final static String SHI_YONG_QIAN_LIANG_CI_ID = "169082";
	*/
/**
	 * 【法视云综合救援】尊贵的主人，您已经全部使用完3次报险试用的机会了，以后请您一定要让我陪在您身边，有需要时记得还有我在哟。
	 *//*

	public final static String SHI_YONG_ZUI_HOU_YI_CI_ID = "169077";
	*/
/**
	 * 【法视云综合救援】{1}您好！您已经成功绑定秒帮{2}设备。秒帮法视云致力于为用户提供个人安全管控一站式综合解决方案，
	 * 为您的安全保驾护航。请您保持设备电量充足，具体使用方法请参见用户手册，感谢您选择秒帮。客服电话：4008779595。
	 *//*

	public static final String BANG_DING_SUCCESS_ID = "168565";
	*/
/**
	 * 【法视云综合救援】{1}您好！秒帮用户{2}，在{3}于{4}附近发出了紧急求救报险信息。
	 * 已与您多次联系未果，请您在收到短信后及时查看处理。
	 *//*

	public static final String KE_FU_1_SUCCESS_ID = "210136";
	*/
/**
	 * 【法视云综合救援】{1}您好！秒帮用户{2}，在{3}于{4}附近发出了紧急求救报险信息。
	 * 我们已向110和120报警处理。已与您多次联系未果，请您在收到短信后及时查看处理。
	 *//*

	public static final String KE_FU_2_SUCCESS_ID = "168560";
	*/
/**
	 * 【法视云综合救援】{1}您好！您的亲人{2}已成为秒帮一键报险终端会员，您是他的紧急联系人，
	 * 当在遇到紧急情况使用秒帮终端报险求助时，您将会在第一时间收到险情信息，为方便您及时查看处理险情，
	 * 请您使用本手机号安装注册秒帮手机客户端http://down.miaosos.com/miaosos.html，
	 * 法视云客服：4008779595，祝您生活愉快。
	 *//*

	public static final String BAND_DING_TO_SHOU_XIN_REN_ID = "168557";
	
	*/
/**
	 * 【法视云综合救援】xxx您好！为方便下次使用，请及时关闭设备，祝您生活愉快，谢谢。
	 *//*

	public static final String TONG_ZHI_DANGSHIREN_GUANBI = "208067";
	
	public static final String TONG_ZHI_DAO_QI_SHI_JIAN ="";

	public static void main(String[] args) {
		Integer sendSms = sendSms("166802", new String[] { "xxx", "123" },
				"13381323200");
		System.out.println(sendSms);
	}

	*/
/**
	 * 
	 * @param TemplateId
	 *            信息模板id
	 * @param smsContent
	 *            信息模板变量内容 无内容传null
	 * @param phone
	 *            需要发送的手机号
	 * @return
	 *//*

	public static int sendSms(String TemplateId, String[] smsContent,
			String... phone) {
		HashMap<String, Object> result = null;
		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init(URL, PORT);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount(ACCOUNT_SID, AUTH_TOKEN);// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId(APP_ID);// 初始化应用ID
		result = restAPI.sendTemplateSMS(phone[0], TemplateId, smsContent);

		// System.out.println("SDKTestSendTemplateSMS result=" + result);
		if ("000000".equals(result.get("statusCode"))) {
			System.out.println("向" + phone[0] + "发送短信成功");
			return 1;
		} else {
			// 异常返回输出错误码和错误信息
			System.out.println("向" + phone[0] + "发送短信失败");
			System.out.println("错误码=" + result.get("statusCode") + " 错误信息= "
					+ result.get("statusMsg"));
			return 0;
		}
	}
}
*/
