package demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;


public class Test3 {

public static void main(String[] args) throws Exception{
//	String url = "https://114.55.39.36/PDF/c6bb90a73f471ad205707e2551beee7e.pdf";
	String url = "https://statictest.yuanbaopu.com/ui/bank/images/listofdata/shopLogo.png";
//	String url = "http://114.55.39.36:8086/PDF/c6bb90a73f471ad205707e2551beee7e.pdf";
	String path = "D:/";
	//�����ļ�������
	System.out.println("--------------���ؿ�ʼ"+new Date());
	downLoadImg(url,path,"AAA.pdf");
	System.out.println("--------------���ؽ���"+new Date());
	//ɾ����ʱ�ļ�
//	File file = new File(path+"jdk.zip");
//	file.delete();
}

/**
 * ���������ַ
 * @param uri  �������ص�ַ
 * @param tmpPath ��ʱ����Ŀ¼
 * @param tmpFileName  ��ʱͼƬ�ļ�����
 * @return
 * @throws Exception
 */
public static File downLoadImg(String uri,String tmpPath,String tmpFileName) throws Exception {
	// newһ��URL����
	URL url = new URL(uri);
	// ������
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	// ��������ʽΪ"GET"
	conn.setRequestMethod("GET");
	// ��ʱ��Ӧʱ��Ϊ5��
	conn.setConnectTimeout(5 * 1000);
	// ͨ����������ȡͼƬ����
	InputStream inStream = conn.getInputStream();
	// �õ�ͼƬ�Ķ��������ݣ��Զ����Ʒ�װ�õ����ݣ�����ͨ����
	byte[] data = readInputStream(inStream);
	// newһ���ļ�������������ͼƬ��Ĭ�ϱ��浱ǰ���̸�Ŀ¼
	File imageFile = new File(tmpPath+"/"+tmpFileName);
	// ���������
	FileOutputStream outStream = new FileOutputStream(imageFile);
	// д������
	outStream.write(data);
	// �ر������
	outStream.close();
	return imageFile;
}
/**
 * �����ļ���
 * @param inStream
 * @return
 * @throws Exception
 */
private static byte[] readInputStream(InputStream inStream)
		throws Exception {
	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	// ����һ��Buffer�ַ���
	byte[] buffer = new byte[1024];
	// ÿ�ζ�ȡ���ַ������ȣ����Ϊ-1������ȫ����ȡ���
	int len = 0;
	// ʹ��һ����������buffer������ݶ�ȡ����
	while ((len = inStream.read(buffer)) != -1) {
		// ���������buffer��д�����ݣ��м����������ĸ�λ�ÿ�ʼ����len�����ȡ�ĳ���
		outStream.write(buffer, 0, len);
	}
	// �ر�������
	inStream.close();
	// ��outStream�������д���ڴ�
	return outStream.toByteArray();
}

}
