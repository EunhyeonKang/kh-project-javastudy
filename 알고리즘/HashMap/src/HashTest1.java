import java.util.Arrays;
public class HashTest1 {
	class Solution {
		public String solution(String[] participant, String[] completion) { 	
	    	String answer = "";
	    	String temp="";
	    	//배열 sort함수 사용
	    	Arrays.sort(participant);
	    	Arrays.sort(completion);
	    	int i=0;
	    	while(i<completion.length) {
	    		//equals 문자열비교
	    		if(!completion[i].equals(participant[i])){
	    			temp=participant[i];
	    			break;
	    		}else {
	    			i++;
	    		}
	    	}
	    	
	        if(!temp.equals("")) {
	        	answer=temp;
	        }else {
	        	answer=participant[participant.length-1];
	        }
	        return answer;
	    }
	}

	public static void main(String[] args) {
		// participant 선수들의 이름 배열
		// completion 완주한 선수들의 이름이 담긴 배열
		// 완주하지 못한 선수들의 이름은 return

	}

}
