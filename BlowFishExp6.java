//Input to be taken = Hello World
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;


public class BlowFish
{	
	public static void main(String[] arg) throws Exception
	{
		KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
		keygenerator.init(128);
		Key secretKey = keygenerator.generateKey();
		Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
		cipherOut.init(Cipher.ENCRYPT_MODE,secretKey);
		Base64.Encoder encoder = Base64.getEncoder();
		
		byte iv[] = cipherOut.getIV();
		if(iv!=null)
		{
			System.out.println("Initialization vector of the cipher:" + encoder.encodeToString(iv));
		}
		FileInputStream Fin = new FileInputStream("inputFile.txt");
		FileOutputStream Fout = new FileOutputStream("outputFile.txt");
		CipherOutputStream cout = new CipherOutputStream(Fout,cipherOut);
		
		int input;
		while( (input=Fin.read())!=-1 )
		{
			cout.write(input);
		}
		
		Fin.close();
		cout.close();
	}
}
