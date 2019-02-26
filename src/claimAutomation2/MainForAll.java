package claimAutomation2;

import java.io.IOException;

public class MainForAll {
	
	public static void main(String as[]) throws IOException, InterruptedException{
		//CreateClaim createClaim = new CreateClaim();
		//createClaim.createclaim();
		
		System.out.println("============================================================================================");
       	System.out.println("============================================================================================");
		
		Creacion cre = new Creacion();
		System.out.println("To Create claim we call Creacion class  ");
		cre.create();
		
		System.out.println("============================================================================================");
		System.out.println("============================================================================================");
		System.out.println("To modify claim we call ModifyClaim class  ");
		ModifyClaim modclaim = new ModifyClaim();
		modclaim.modifyClaim();
		
		System.out.println("============================================================================================");
		System.out.println("============================================================================================");
		System.out.println("To anul claim we call Anulcion class ");
		Anulacion anul = new Anulacion();
		anul.anulcion();
		
		System.out.println("============================================================================================");
		System.out.println("============================================================================================");
		
		ReopenExpediente reclaim = new ReopenExpediente();
		System.out.println("To reopen claim we call Reopen class  ");
		reclaim.reopenClaim();
		
		
		
		
		
	}

}
