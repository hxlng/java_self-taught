package project01;

class FamilyAccount{
	public static void main(String[] args){
		boolean isFlag=true;
		//���ڼ�¼�û��������֧��������
		
		String details="��֧\t�˻����\t��֧���\t˵      ��\n";
		//��ʼ���
		int balance=10000;
		
		
		while(isFlag){
			System.out.println("---------------��ͥ��֧�������-------------------\n");
			System.out.println("		1 ��֧��ϸ		                    ");
			System.out.println("		2 �Ǽ�����		                    ");
			System.out.println("		3 �Ǽ�֧��		                    ");
			System.out.println("		4 �� ��		                   \n ");
			System.out.print("		��ѡ��(1-4): ");
			
			//��ȡ�û���ѡ��1-4
			char selection=Utility.readMenuSelection();
			switch(selection){
				
				case '1' :
//				System.out.println("1.��֧��ϸ");
					System.out.println("---------------��ǰ��֧��ϸ��¼-------------------");
//					System.out.println("��֧\t�˻����\t��֧���\t˵      ��\n");
					System.out.println(details);
					System.out.println("----------------------------------------------");
					
				break;
				case '2' :
//				System.out.println("2.�Ǽ�����");
					System.out.println("����������");
					int addMoney=Utility.readNumber();
					System.out.println("��������˵��");
					String addInfo=Utility.readString();
					//����balance
					balance += addMoney;
					
					//����details
					details +=("����\t"+balance+"\t"+addMoney+"\t"+addInfo+"\n");
					
					
					
					System.out.println("---------------  �Ǽ����   -------------------");
				break;
				case '3' :
//				System.out.println("3.�Ǽ�֧��");
					System.out.println("����֧�����");	
					int minusMoney=Utility.readNumber();
					System.out.println("����֧��˵��");
					String minusInfo=Utility.readString();
					
					//����balance
					if(balance>=minusMoney) {
						balance -=minusMoney;
						//����details
						details +=("֧��\t"+balance+"\t"+minusMoney+"\t"+minusInfo+"\n");
					}else {
						System.out.println("֧�������˻���ȣ�֧��ʧ��");
					}
					
					System.out.println("---------------  �Ǽ����   -------------------\n");
					
				break;
				case '4' :
//				System.out.println("4.��    ��");
					System.out.print("ȷ���Ƿ��˳�(Y/N):");
					char isExit=Utility.readConfirmSelection();
					if(isExit=='Y') {
						isFlag=false;
					}
				break;
				
				
			}
		}
	}
}