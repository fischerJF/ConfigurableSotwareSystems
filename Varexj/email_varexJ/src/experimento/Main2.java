package experimento;

import EmailSystem.Client;

public class Main2 {

	public static void main(String[] args) {
		Client sender = Client.createClient("mysender");
		int recipientsCount = 500;
		for (int i = 0; i < recipientsCount; i++) {
			Client c = Client.createClient("myreceiver" + i);
			c.setPrivateKey(i);
			sender.addKeyringEntry(c, i);
			System.out.println(" teste");
		}
		String recipientAddr = "myreceiver"
				+ String.valueOf(recipientsCount - 1);
		Client recipient = Client.getClientByAdress(recipientAddr);
		int pubkey = sender.getKeyringPublicKeyByClient(recipient);

	}

}
