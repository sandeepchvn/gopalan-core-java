package arrayPrograms;

public class Practice {

	public static void main(String[] args) {
		String st="annabfff";
		char[] ch=st.toCharArray();
		boolean[] isChecked=new boolean[ch.length];
		
		for(int i=0;i<ch.length;i++) {
			int c=1;
			if(isChecked[i]==false) {
				for(int j=i+1;j<ch.length;j++) {
					if(ch[i]==ch[j]) {
						c++;
						isChecked[j]=true;
					}
				}
				System.out.println(ch[i]+"->"+c);
			}
		}
	}
}
