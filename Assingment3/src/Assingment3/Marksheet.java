package Assingment3;
/**
 * A class Marksheet, which reads in grades of n no of students
 * @author krishna.meghwal_meta
 * @since 25-02-21
 */
public class Marksheet {
	int[] marks ;
	int length;
	
	public Marksheet(int[] marks){
		this.marks = marks;
		this.length = marks.length;
	}
	
	/**Return average of all grades
	 * @return float*/
	public float avgGrades(){
		
		float avgGrade;
		float totalGrade = 0.0f;
		
		for(int i=0; i < this.length; i++){
			totalGrade += this.marks[i];
		}
		avgGrade = totalGrade/this.length;
		return Math.round(avgGrade*100)/100;
	}
	
	/**Return maximum of all grades
	 * @return int*/
	public int maxGrade(){
		int maximum = Integer.MIN_VALUE;
		
		for(int i=0; i<this.length; i++){
			if(maximum < this.marks[i]){
				maximum = this.marks[i];
			}
		}
		
		return maximum;
	}
	
	/**Return minimum of all grades
	 * @return int */
	public int minGrade(){
		int minimum = Integer.MAX_VALUE;
		
		for(int i=0; i < this.length; i++){
			if(minimum > this.marks[i]){
				minimum = this.marks[i];
			}
		}
		
		return minimum;
	}
	/**Return percentage of students passed
	 * @return float */
	public float studentPassedPercentage(){
		
		int totalStudentPassed = 0;
		for(int i = 0; i<this.length;i++){
			if(this.marks[i] >= 40)
				totalStudentPassed += 1;
		}
		float answer = totalStudentPassed / this.length ;
		return Math.round(answer*100)/100;
		
	}
}
