package wscli;

public class TestWS {

	public static void main(String[] args) {

		FindUserService afindUserService = new FindUserService();
		
		FindUser findUserClient = afindUserService.getFindUserPort();
		
		
		findUserClient.findUserByName("admin");
		
		

	}

}
