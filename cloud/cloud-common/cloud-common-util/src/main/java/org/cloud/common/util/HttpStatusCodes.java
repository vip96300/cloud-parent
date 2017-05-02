package org.cloud.common.util;


/**
 * http status codes
 * @author XiaoHuiHui
 *
 */
public class HttpStatusCodes {
	
	/**
	 * �������ͻ���Ӧ����������
	 */
	public static final int Continue=100;
	/**
	 * �л�Э�顣���������ݿͻ��˵������л�Э�顣ֻ���л������߼���Э�飬���磬�л���HTTP���°汾Э��
	 */
	public static final int SwitchingProtocols=101;
	/**
	 * ����ɹ���һ������GET��POST����
	 */
	public static final int OK=200;
	/**
	 * �Ѵ������ɹ����󲢴������µ���Դ
	 */
	public static final int Created=201;
	/**
	 * �ѽ��ܡ��Ѿ��������󣬵�δ�������
	 */
	public static final int Accepted=202;
	/**
	 * ����Ȩ��Ϣ������ɹ��������ص�meta��Ϣ����ԭʼ�ķ�����������һ������
	 */
	public static final int NonAuthoritativeInformation=203;
	/**
	 * �����ݡ��������ɹ�������δ�������ݡ���δ������ҳ������£���ȷ�������������ʾ��ǰ�ĵ�
	 */
	public static final int NoContent=204;
	/**
	 * �������ݡ�����������ɹ����û��նˣ����磺�������Ӧ�����ĵ���ͼ����ͨ���˷��������������ı���
	 */
	public static final int ResetContent=205; 
	/**
	 * �������ݡ��������ɹ������˲���GET����
	 */
	public static final int PartialContent=206;
	/**
	 * ����ѡ���������Դ�ɰ������λ�ã���Ӧ�ɷ���һ����Դ�������ַ���б������û��նˣ����磺�������ѡ��
	 */
	public static final int MultipleChoices=300;
	/**
	 * �����ƶ����������Դ�ѱ����õ��ƶ�����URI��������Ϣ������µ�URI����������Զ�������URI������κ��µ�����Ӧʹ���µ�URI����
	 */
	public static final int MovedPermanently=301;
	/**
	 * ��ʱ�ƶ�����301���ơ�����Դֻ����ʱ���ƶ����ͻ���Ӧ����ʹ��ԭ��URI
	 */
	public static final int Found=302;
	/**
	 * �鿴������ַ����301���ơ�ʹ��GET��POST����鿴
	 */
	public static final int SeeOther=303;
	/**
	 * δ�޸ġ����������Դδ�޸ģ����������ش�״̬��ʱ�����᷵���κ���Դ���ͻ���ͨ���Ỻ����ʹ�����Դ��ͨ���ṩһ��ͷ��Ϣָ���ͻ���ϣ��ֻ������ָ������֮���޸ĵ���Դ
	 */
	public static final int NotModified=304;
	/**
	 * ʹ�ô������������Դ����ͨ���������
	 */
	public static final int UseProxy=305;
	/**
	 * �Ѿ���������HTTP״̬��
	 */
	public static final int Unused=306;
	/**
	 * ��ʱ�ض�����302���ơ�ʹ��GET�����ض���
	 */
	public static final int TemporaryRedirect=307;
	/**
	 * �ͻ���������﷨���󣬷������޷����
	 */
	public static final int BadRequest=400;
	/**
	 * ����Ҫ���û��������֤
	 */
	public static final int Unauthorized=401;
	/**
	 * ����������ʹ��
	 */
	public static final int PaymentRequired=402;
	/**
	 * �������������ͻ��˵����󣬵��Ǿܾ�ִ�д�����
	 */
	public static final int Forbidden=403;
	/**
	 * �������޷����ݿͻ��˵������ҵ���Դ����ҳ����ͨ���˴��룬��վ�����Ա������"�����������Դ�޷��ҵ�"�ĸ���ҳ��
	 */
	public static final int NotFound=404;
	/**
	 * �ͻ��������еķ�������ֹ
	 */
	public static final int MethodNotAllowed=405;
	/**
	 * �������޷����ݿͻ�����������������������
	 */
	public static final int NotAcceptable=406;
	/**
	 * ����Ҫ�����������֤����401���ƣ���������Ӧ��ʹ�ô��������Ȩ
	 */
	public static final int ProxyAuthenticationRequired=407;
	/**
	 * �������ȴ��ͻ��˷��͵�����ʱ���������ʱ
	 */
	public static final int RequestTimeout=408;
	/**
	 * ��������ɿͻ��˵�PUT�����ǿ��ܷ��ش˴��룬��������������ʱ�����˳�ͻ
	 */
	public static final int Conflict=409;
	/**
	 * �ͻ����������Դ�Ѿ������ڡ�410��ͬ��404�������Դ��ǰ�����ڱ�����ɾ���˿�ʹ��410���룬��վ�����Ա��ͨ��301����ָ����Դ����λ��
	 */
	public static final int Gone=410; 
	/**
	 * �������޷�����ͻ��˷��͵Ĳ���Content-Length��������Ϣ
	 */
	public static final int LengthRequired=411;
	/**
	 * �ͻ���������Ϣ���Ⱦ���������
	 */
	public static final int PreconditionFailed=412;
	/**
	 * ���������ʵ����󣬷������޷�������˾ܾ�����Ϊ��ֹ�ͻ��˵��������󣬷��������ܻ�ر����ӡ����ֻ�Ƿ�������ʱ�޷�����������һ��Retry-After����Ӧ��Ϣ
	 */
	public static final int RequestEntityTooLarge=413;
	/**
	 * �����URI������URIͨ��Ϊ��ַ�����������޷�����
	 */
	public static final int RequestURITooLarge=414;
	/**
	 * �������޷��������󸽴���ý���ʽ
	 */
	public static final int UnsupportedMediaType=415;
	/**
	 * �ͻ�������ķ�Χ��Ч
	 */
	public static final int Requestedrangenotsatisfiable=416;
	/**
	 * �������޷�����Expect������ͷ��Ϣ
	 */
	public static final int ExpectationFailed=417;
	/**
	 * �������ڲ������޷��������
	 */
	public static final int InternalServerError=500;
	/**
	 * ��������֧������Ĺ��ܣ��޷��������
	 */
	public static final int NotImplemented=501;
	/**
	 * �䵱���ػ����ķ���������Զ�˷��������յ���һ����Ч������
	 */
	public static final int BadGateway=502;
	/**
	 * ���ڳ��ػ�ϵͳά������������ʱ���޷�����ͻ��˵�������ʱ�ĳ��ȿɰ����ڷ�������Retry-Afterͷ��Ϣ��
	 */
	public static final int ServiceUnavailable=503;
	/**
	 * �䵱���ػ����ķ�������δ��ʱ��Զ�˷�������ȡ����
	 */
	public static final int GatewayTimeout=504;
	/**
	 * ��������֧�������HTTPЭ��İ汾���޷���ɴ���
	 */
	public static final int HTTPVersionnotsupported=505;
 	
}
