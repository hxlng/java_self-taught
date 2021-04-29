package com.atguigu.team.service;

import com.atguigu.team.domain.*;

//�����Ŷӳ�Ա�Ĺ�����ӡ�ɾ��
public class TeamService {
	private static int counter=1; //�Զ������Ŷӵ�TID
	private final int MAX_MEMBER=5; //�Ŷ�����Ա��
	private Programmer[] team=new Programmer[MAX_MEMBER];  //�����Ŷӳ�Ա
	
	private int total;//��¼�Ŷ�ʵ������
	public TeamService() {
		super();
	}
	
	//��ȡ�����Ŷ��е����г�Ա
	public Programmer[] getTeam() {
		
		Programmer[] team=new Programmer[total];
		for(int i=0; i<team.length;i++) {
			team[i]=this.team[i];
		}
		
		return team;
	}
	
	
	//��ָ����Ա����ӵ������Ŷ���
	public void addMember(Employee e) throws TeamException {
//		��Ա�������޷����
		if(total>=MAX_MEMBER) {
			throw new TeamException("��Ա�������޷����");
		}
		
//		�ó�Ա���ǿ�����Ա���޷����
		if(!(e instanceof Programmer)) {
			throw new TeamException("�ó�Ա���ǿ�����Ա���޷����");
		}
		
//		��Ա�����ڱ������Ŷ���
		if(isExist(e)) {
			throw new TeamException("��Ա�����ڱ������Ŷ���");
		}
//		��Ա������ĳ�Ŷӳ�Ա 
//		��Ա�����ݼ٣��޷����
		//����������status�ж�
		Programmer p=(Programmer)e; //һ���������ClassCastException�쳣 ǰ���Ѿ��ж�
		
		if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) { //if(p.getStatus().getNAME().equals("BUSY")) �����˿�ָ���쳣��
			
			throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
		}else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("��Ա�������ݼ٣��޷����");
		}
		
//		�Ŷ�������ֻ����һ���ܹ�ʦ
//		�Ŷ�������ֻ�����������ʦ
//		�Ŷ�������ֻ������������Ա
		//��ȡteam�Ѿ��еļܹ�ʦ�����ʦ������Ա������
		int numOfArch=0,numOfDes=0,numOfPro=0;
		for(int i=0;i<total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if (team[i] instanceof Designer) {
				numOfDes++;
			}else if(team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		
		if(p instanceof Architect) {
			if(numOfArch>=1) {
				throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
			}else if(p instanceof Designer) {
				if(numOfDes>=2) {
					throw new TeamException("�Ŷ�������ֻ�����������ʦ");
				}
			}else if(p instanceof Programmer) {
				if(numOfPro>=3) {
					throw new TeamException("�Ŷ�������ֻ������������Ա");
				}
			}
		}
		
		//����д��   �߼��ϾͲ���
//		if(p instanceof Architect && numOfArch>=1) {  
//			throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
//		}   
		
		//��p��e ��ӵ����е�team��
			team[total++]=p;
		//p�����Ը�ֵ
			p.setStatus(Status.BUSY);
			p.setMemberId(counter++);  //д����ӵ�team֮ǰҲ�� ��ֵַ����
			
		
	}
	
	
	//�ж�ָ����Ա���Ƿ��Ѿ��������еĿ����Ŷ���
	private boolean isExist(Employee e) {
		
		for(int i=0; i<total;i++) {
			if(team[i].getId()==e.getId()) {// Ҳ������memberId ֻ������Ҫת��
				return true;
				
			}
		}
		return false;
	}

	//���Ŷ���ɾ����Ա
	public void removeMember(int memberId) throws TeamException {
		int i;
		for( i=0;i<total;i++) {
			if(team[i].getMemberId()==memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		// δ�ҵ�ָ��memberId�����
		if(i==total) {
			throw new TeamException("�Ҳ���ָ��memberId��Ա����ɾ��ʧ��");
		}
		
		//�����Ԫ�ظ���ǰһ��Ԫ�أ�ʵ��ɾ������
		for(int j=i+1;j<total;j++) {
			team[j-1]=team[j];
		}
		
//		for(int j=i;j<total-1;j++) {
//			team[j]=team[j+1];
//		}
		
		//д��һ
//		team[total-1]=null;
//		total--;
		//д����
		team[--total]=null;
		
	}
	
	
}
