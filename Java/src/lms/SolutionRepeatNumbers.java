package lms;

public class SolutionRepeatNumbers {
	public static void main(String[] args) {
//		String[] nums = args;
		for(int i = 0; i < args.length; i++) {
			int count = 1;
//			System.out.println(args[i]);
			for(int j = i + 1; j < args.length; j++) {
//				System.out.print(args[j]);
				if(args[i].equals(args[j])) {
//					System.out.print(args[j]);
					args[j] = "#";
					count++;
				}
			}
			if(count > 1 && args[i] != "#")
				System.out.print(args[i]);
		}
	}
}
