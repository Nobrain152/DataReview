package user;

import static org.junit.Assert.assertEquals;

import bl.userbl.MD5Util;
//pass
public class Testmd {

	
	
	public static void main(String[] args) {
		String s1="12345679";
		String s2="66666666";
		String s3="88888888";
		String s4="cc151250005";
		String s5="CC15ruanjian";
		String s6=MD5Util.md5Encode(s1);
		String s7=MD5Util.md5Encode(s2);
		String s8=MD5Util.md5Encode(s3);
		String s9=MD5Util.md5Encode(s4);
		String s10=MD5Util.md5Encode(s5);
		assertEquals(s6,MD5Util.md5Encode(s1));
		assertEquals(s7,MD5Util.md5Encode(s2));
		assertEquals(s8,MD5Util.md5Encode(s3));
		assertEquals(s9,MD5Util.md5Encode(s4));
		assertEquals(s10,MD5Util.md5Encode(s5));
		System.out.println(MD5Util.md5Encode("12345678"));
	}

}
