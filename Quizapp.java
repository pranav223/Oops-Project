
package quizapp;
import java.util.Scanner;


public class Quiz_Application {
	
	public static  void main(String[] args) {
		 Quiz quiz=new Quiz();
	       quiz.begin();
	}

}
class Quiz
{
    void begin()
    {
        Question q1=new Question("which is valid keyword in java?","interface","inherit","aunsigned","derive",new Answer("interfaces"));
        Question q2=new Question("Where does an object gets created in memory?","Stack","Queue","Heap","None Of THE Above",new Answer("Heap"));
        Question q3=new Question("which keyword is used to prevent a method getting overriden? ","extends","final","static","implements",new Answer("final"));
        Question q4=new Question("for what purpose is this() constructor call used?","to invoke a parent class constructor","to invoke a child class constructor","to invoke another constructor of same class","to invoke another constructor of different class",new Answer("to invoke another constructor of same class"));
        Question q5=new Question("When does an object becomes unreacheable?","When its reference is pointing to null","When its reference is pointing to Another object","When the method in which it is defined ends","All of the above", new Answer("All of the above"));
        Question questionsarr[]={q1,q2,q3,q4,q5};
        int countTotal=0;
        int countcorrect=0;
        int countwrong=0;
        for(Question q:questionsarr)
        {
            System.out.println(q.getQuestion());
            System.out.println("A, "+q.getOption1());
            System.out.println("B, "+q.getOption2());
            System.out.println("C, "+q.getOption3());
            System.out.println("D, "+q.getOption4());
            System.out.println("\nEnter an option");
            Scanner scanner=new Scanner(System.in);
            char option=scanner.next().charAt(0);
            String answer="";
            switch(option)
            {
                case 'A':
                    answer=q.getOption1();
                    break;
                case 'B':
                    answer=q.getOption2();
                    break;
                case 'C':
                    answer=q.getOption3();
                    break;
                case 'D':
                    answer=q.getOption4();
                    break;
                default:break;    
                
            }
            if(answer.equals(q.answer.getAnswer()))
            {
                System.out.println("-----------------------------------");
                System.out.println("Correct Answer");
                System.out.println("----------------------------------");
                countcorrect++;
                
            }
            else{
                System.out.println("-----------------------------------");
                System.out.println("Wrong Answer");
                System.out.println("-----------------------------------");
              countwrong++;
            }
            System.out.println("\n=====================================\n");
            countTotal++;
            
        }
        IResult result=new Result(countTotal,countcorrect,countwrong);
        result.showResult();

    }
}


class Question
{
    String question;
    String option1;
    String option2;
    String  option3;
    String option4;
    Answer answer;
	public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
		super();
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public String getOption1() {
		return option1;
	}
	public String getOption2() {
		return option2;
	}
	public String getOption3() {
		return option3;
	}
	public String getOption4() {
		return option4;
	}
	public Answer getAnswer() {
		return answer;
	}
    
}
class Answer
{
	String answer;

	public Answer(String answer) {
		super();
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}
	
}
interface IResult
{
	void showResult();
	double showPercentage(int correctAnswers,int totalQuestions);
	String showPerformance(double percentage);
}
 class Result implements IResult
{
	int totalQuestions;
	int correctAnswers;
	int wrongAnswers;
	public Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
		super();
		this.totalQuestions = totalQuestions;
		this.correctAnswers = correctAnswers;
		this.wrongAnswers = wrongAnswers;
	}
	public void showResult() {
		System.out.println("YOUR RESULT");
		System.out.println("TOTAL QUESTIONS;      "+totalQuestions);
		System.out.println("CORRECT ANSWERS;       "+correctAnswers);
		System.out.println(("Wrong ANSWERS;         "+wrongAnswers));
		System.out.println("PERCENTAGE;              "+showPercentage(correctAnswers,totalQuestions));
		System.out.println("OVERALL PERFORMANCE;       "+showPerformance(showPercentage(totalQuestions,correctAnswers)));
		
	}
	public double showPercentage(int correctAnswers,int totalQuestions) {
		return ((double)correctAnswers/totalQuestions)*100;
	}
	public String showPerformance(double Percentage) {
		String ans="";
		if(Percentage>60) {
			ans= "Good";
		}
		else if(Percentage<40) {
			ans= "poor";
		}
		else {
  			ans= "Average";
		}
		return ans;
		
	}
}
   