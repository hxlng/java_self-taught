package com.atguigu.team.domain;


public class Designer extends Programmer {
	private double bonus; //����
	
	public Designer() {
		super();
		
	}
	
	public Designer(int id,String name,int age,double salary,Equipment equipment,double bonus) {
		super(id,name,age,salary,equipment);
		this.bonus=bonus;
		
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		//status˽�����Բ���ֱ�ӵ�
		return getDetails()+"\t���ʦ"+"\t"+getStatus()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
	}
	
	@Override
	public String getDetailsForTeam() {
		
		return getMemberDetails()+"\t���ʦ\t" + getBonus();
	}
}
