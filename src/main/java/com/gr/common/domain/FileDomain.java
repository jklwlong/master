package com.gr.common.domain;

import java.io.File;

public class FileDomain {
	private File file;// ʵ���ϴ��ļ�
	private String attachmentContentType; // �ļ�����������
	private String attachmentFileName; // �ϴ��ļ���
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getAttachmentContentType() {
		return attachmentContentType;
	}
	public void setAttachmentContentType(String attachmentContentType) {
		this.attachmentContentType = attachmentContentType;
	}
	public String getAttachmentFileName() {
		return attachmentFileName;
	}
	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

}
