import java.util.ArrayList;

import java.util.Scanner;

public class BonusAssignment {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Double> gpa = new ArrayList<Double>();
		ArrayList<String> gender = new ArrayList<String>();
		ArrayList<String> major = new ArrayList<String>();
		ArrayList<String> state = new ArrayList<String>();

		String currName, currGender, currMajor, currState;

		double currGPA = 0.0, sum = 0.0, sumM = 0.0, sumF = 0.0;
		int numM = 0, numF = 0;

		System.out.println("IS Communit Schoo Classes Program");
		System.out.println(" type  \"exit\" to exit this program.");
		System.out.println("-------------------------------------- \n");

		System.out.println("Enter Student Name:");
		currName = s.nextLine();

		while (!currName.equals("exit") && !currName.equals("done")
				&& currGPA >= 0) {

			System.out.println(" Letter Grade: ");
			currGPA = letterToGPA(s.nextLine());

			System.out.println(" Gender: ");
			currGender = s.nextLine();
			currGender.toUpperCase();
			
			System.out.println(" Major: ");
			currMajor = s.nextLine();

			System.out.println(" State: ");
			currState = s.nextLine();
			currState.toUpperCase();

			name.add(currName);

			sum += currGPA;
			gpa.add(currGPA);

			if (currGender.equals("M")) {
				sumM += currGPA;
				numM++;
			}
			if (currGender.equals("F")) {
				sumF += currGPA;
				numF++;
			}
			gender.add(currGender);

			major.add(currMajor);
			state.add(currState);

			System.out.print("Enter Student Name: ");
			currName = s.nextLine();

		}
		System.out.println("\n =========== \n");

		for (int i = 0; i < gpa.size(); i++) {
			System.out.println("\nStudent " + (i + 1) + ": " + name.get(i));
			System.out.println(" GPA: " + gpa.get(i));
			System.out.println(" Gender: " + gender.get(i));
			System.out.println(" Major: " + major.get(i));
			System.out.println(" State: " + state.get(i));
		}
		System.out.println("\n =========== \n");

		System.out.println("Overall Average: " + (sum / gpa.size()));

		System.out.println("Average by Gender: ");
		System.out.println(" Males: " + (sumM / numM));
		System.out.println(" Females: " + (sumF / numF));

		System.out.println("Average by Major: ");
		averageBy(major, gpa);

		System.out.println("Average by State: ");
		averageBy(state, gpa);

		System.out.println("\n =========== \n");
		System.out.println("Done.");
		s.close();

	}

	static double letterToGPA(String grade) {
		grade.toUpperCase();
		char letter = grade.charAt(0);
		if (letter == 'A') {
			return 4.0;
		}else if(letter == 'B'){
			return 3.0;
		}else if(letter == 'C'){
			return 2.0;
		}else if(letter == 'D'){
			return 1.0;
		}else if(letter == 'E' || letter == 'F') {
			return 0.0;
		}else {
			return -1.0;
		}
	}

	

	static void averageBy(ArrayList<String>avgBy, ArrayList<Double>gpa) {
		String curr = "";
		for (int i = 0; i < avgBy.size(); i++) {
			if (avgBy.get(i).equals("-")) {
				continue;
			}
			int div = 0;
			double sum = 0.0;
			curr = avgBy.get(i).toString();
			avgBy.set(i, "-");
			sum += gpa.get(i);
			div++;
			for (int j = i+1; j< avgBy.size(); j++) {
				if (!avgBy.get(j).equals("-") && avgBy.get(j).equals(curr)) {
					avgBy.set(j, "-");
					sum +=gpa.get(j);
					div++;
					
				}
			}
			System.out.println(" " + curr + ": " + (sum/div));
		}
	}

}

