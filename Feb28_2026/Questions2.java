package assignment.feb28;

import java.util.HashMap;

class UsernameExistsException extends RuntimeException {
	public UsernameExistsException(String message) {
		super(message);
	}
}

class UserInfoMap extends HashMap<String, String> {
	@Override
	public String put(String key, String value) {
		if (this.containsKey(key)) {
			throw new UsernameExistsException("Username " + key + " already exists!");
		}
		
		return super.put(key, value);
	}
}

public class Question2 {
	public static void main(String[] args) {
		UserInfoMap uinfoMap = new UserInfoMap();
		
		try {
			uinfoMap.put("rhythm", "123");
			System.out.println("Username rhythm added successfully.");
			
			uinfoMap.put("rhythm", "1234");
		} catch (UsernameExistsException e) {
			System.out.println(e.getMessage());
		}
	}
}
