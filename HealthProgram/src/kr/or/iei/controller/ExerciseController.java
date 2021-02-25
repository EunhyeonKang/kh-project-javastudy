package kr.or.iei.controller;

import kr.or.iei.model.vo.Exercise;
import kr.or.iei.model.vo.PT;
import kr.or.iei.model.vo.Pilates;
import kr.or.iei.model.vo.Spinning;
import kr.or.iei.view.AdminView;
import kr.or.iei.view.MainView;
import kr.or.iei.view.UserView;

public class ExerciseController {
	Exercise[] Ex;
	Exercise[] Ex1; 
	int index;
	int index1;
	MainView mView;
	AdminView aView;
	UserView uView;
	boolean bool;
	boolean bool1;
	boolean bool2;
	public ExerciseController() {
		super();
		Ex = new Exercise[30];
		Ex1 = new Exercise[30];
		index=0;
		index1=0;
		Ex[index++] = new Pilates("필라테스","예쁜바디반","101A","김종국",30,3);
		Ex[index++] = new Spinning("스피닝","----반","102B","유재석",25,3);
		Ex[index++] = new PT("PT","----반","103C","이광수",20,3);
		mView = new MainView();
		aView = new AdminView();
		uView = new UserView();
		bool = true;
		bool1 = true;
		bool2 = true;

	}
	//메인시작
	public void main() {
		while(true) {
			int sel = mView.selectMember();
			switch(sel) {
			//관리자
			case 1:
				while (true) {
					switch (aView.manageMenu()) {
					case 1:
						insertProgram();
						break;
					case 2:
						printAllProgram();
						break;
					case 3:
						printOneProgram();
						break;
					case 4:
						modifyProgram();
						break;
					case 5:
						deleteProgram();
						break;
					case 0:
						mView.printMsg("뒤로가기");
						break;
					}
					break;
				}
				break;
			//사용자
			case 2:
				mView.printMsg("헬스클럽에 오신걸 환영합니다~~");
				while(true) {
					int uSel = uView.showMenu();
					switch(uSel) {
					//프로그램조회
					case 1:
						int searchSel = uView.serchMenu();
						 while(true) {
		                     switch(searchSel) {
		                     case 1:
		                        uView.totalProgramSearch(Ex,index);
		                        break;
		                     case 2:
		                    	uView.privProgramSearch(Ex1,index1);
		                        break;
		                     case 0:
		                        break;
		                     }
		                   	break;
		                  }
		                  break;
					//수강 등록 신청
					case 2:
						String cSel = uView.insertProgram("수강 등록");
						//개인조회
						Ex1[index1++] = uView.inputProgram(cSel);
						
						int searchIndex = searchProgram(cSel);
						
						if(searchIndex==-1){
							mView.printMsg("프로그램 명이 존재하지 않습니다.");
						}else {
							while(true) {
								mView.printMsg("정원 수가"+ Ex[searchIndex].getTotalNum() +"명 입니다.");
								int rSel = uView.classRegister(cSel);
								switch(rSel) {
								case 1:
									mView.printMsg("수강이 완료되었습니다.");
									int currNum = Ex[searchIndex].getTotalNum();
									Ex[searchIndex].setTotalNum(currNum - 1);
									break;
								case 2:
									break;
								}
								break;
							}
						}
						break;
					//수강 탈퇴 신청
					case 3:
						String oSel = uView.insertProgram("수강 등록");
						searchIndex = searchProgram(oSel);
						if(searchIndex==-1){
							mView.printMsg("프로그램 명이 존재하지 않습니다.");
						}else {
							while(true) {
								mView.printMsg("정원 수가"+ Ex[searchIndex].getTotalNum() +"명 입니다.");
								int rSel = uView.classExit(oSel);
								switch(rSel) {
								case 1:
									mView.printMsg("수강탈퇴가 완료되었습니다.");
									//getter로 값을 가져와서 setter를 통해 수정함
									int currNum = Ex[searchIndex].getTotalNum();
									Ex[searchIndex].setTotalNum(currNum + 1);
									bool1=false;
									break;
								case 2:
									bool1=false;
									break;
								}
								if(bool1==false)break;
							}
						}
						break;
					case 4:
						bool2=false;
						break;
					}
					if(bool2==false)break;
				}
				
				break;
			//종료
			case 0:
				mView.printMsg("안녕히 가세요~");
				return;
			}
		}
	}
	
	public void insertProgram() {
		Exercise exer = aView.getName("등록");
		if(exer != null) {
			Ex[index++] = exer;
		}
	}

	public void printAllProgram() {
		aView.printAllProgram(Ex, index);
	}	

	public void printOneProgram() {
		String name = aView.inputName("조회");
		int searchIndex = searchProgram(name);
		
		if(searchIndex == -1) {
			aView.printMsg("프로그램 정보가 없습니다");
		}else {
			aView.printOneProgram(Ex[searchIndex]);
		}
		
	}

	public void modifyProgram() {
		int searchIndex = searchProgram(aView.inputName("수정"));
		if(searchIndex == -1) {
			mView.printMsg("프로그램 정보가 없습니다");
		}else {
			Exercise exr = aView.getName("수정");
			if(exr != null) {
				Ex[searchIndex] = exr;
			}
			
		}

	}

	public void deleteProgram() {
		int searchIndex = searchProgram(aView.inputName("삭제"));
		if(searchIndex == -1) {
			mView.printMsg("프로그램 정보가 없습니다");
		}else {
			for(int i = searchIndex; i < index ; i++) {
				Ex[i] = Ex[i+1];
			}
			Ex[--index] = null;
		}

	}
	public int searchProgram(String name) {
		for(int i =0; i < index; i++) {
			if(Ex[i].getSubName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
