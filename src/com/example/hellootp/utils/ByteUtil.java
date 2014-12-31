package com.example.hellootp.utils;

public class ByteUtil {
	
	// Do not use
	public byte[] toString2Hex(String hexText) {
		// 1. hex string -> byte array
		byte[] bytes = new java.math.BigInteger(hexText, 16).toByteArray();

		return bytes;
	}

	// Do not use
	public String toHex2String(byte[] bytes) {
		// 2. byte array -> hex string
		String hexText = new java.math.BigInteger(bytes).toString(16);

		return hexText;
	}

	
	public byte[] hex2byte(String p){
		if(p==null || p.length()%2==1) return null;
		byte[] b = new byte[p.length() / 2];
		for( int i=0;i<b.length;i++){
			b[i]=(byte)Integer.parseInt(p.substring(2*i, 2*i+2), 16);
		}
		return b;
	}
	
	public String byte2hex(byte[] b){
		String hs="";
		String stmp="";
		
		for(int i=0;i<b.length; i++){
			stmp=(java.lang.Integer.toHexString(b[i]&0xFF));
			if( stmp.length()==1 ){
				hs=hs+"0"+stmp;
			}else{
				hs=hs+stmp;
			}
			
			if(i<b.length -1){
				hs=hs+"";
			}
		}
		
		return hs;
	}
	
	public String toHexString(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			sb.append(Integer.toHexString(0x0100 + (buf[i] & 0x00FF))
					.substring(1));
		}
		return sb.toString();
	}

	public void printHEX(String st) {
		for (int i = 0; i < st.length(); i++) {
			int ch = (int) st.charAt(i);
			System.out.format("%04X", ch);
		}
	}

	public void printHEX(byte[] ba) {
		byte c;
		for (int i = 0; i < ba.length; i++) {
			c = ba[i];
			System.out.format("%02X", c);
		}
	}

}
