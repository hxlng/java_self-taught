package com.atguigu.team.domain;

public class Architect extends Designer{
	private int stock;//��Ʊ
	
	public Architect() {
		super();
		
	}
	public Architect(int id,String name,int age,double salary,Equipment equipment,double bonus,int stock) {
			super(id,name,age,salary,equipment,bonus);
			this.stock=stock;
	}
	
	public void setStock(int stock) {
		this.stock=stock;
		
	}
	
	public int getStock() {
		return stock;
	}
	@Override
	public String toString() {
		return getDetails()+"\t�ܹ�ʦ"+"\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
	}
	
	@Override
	public String getDetailsForTeam() {
		return getMemberDetails() + "\t�ܹ�ʦ\t" + 
	               getBonus() + "\t" + getStock();
	}
}
