package com.atguigu.surveypark.model.security;

import com.atguigu.surveypark.model.BaseEntity;

/**
 * Ȩ��
 */
public class Right extends BaseEntity {
	private static final long serialVersionUID = 4066371171928834726L;
	private Integer id;
	private String rightName = "δ����";
	private String rightUrl;
	private String rightDesc;
	private long rightCode;// Ȩ����,1<<n
	private int rightPos; // Ȩ��λ,�൱�ڶ�Ȩ�޷���,��0��ʼ
	//�Ƿ��ǹ�����Դ
	private boolean common ;

	public boolean isCommon() {
		return common;
	}

	public void setCommon(boolean common) {
		this.common = common;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getRightUrl() {
		return rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightDesc() {
		return rightDesc;
	}

	public void setRightDesc(String rightDesc) {
		this.rightDesc = rightDesc;
	}

	public long getRightCode() {
		return rightCode;
	}

	public void setRightCode(long rightCode) {
		this.rightCode = rightCode;
	}

	public int getRightPos() {
		return rightPos;
	}

	public void setRightPos(int rightPos) {
		this.rightPos = rightPos;
	}
}