package com.project0.StudyBuddy;
import java.util.Scanner;

public class Quiz
{
    void begin()
    {
        Question[] questions = new Question[5];

        questions[0] = new Question("Q 1 - Method Overloading is an example of","Static Binding.","Dynamic Binding.","Both of the above.","None of the above.", new Answer("Static Binding."));
        questions[1] = new Question("Q 2 - What is the default value of byte variable?"," 0.0","0","Null","Not defined", new Answer("0"));
        questions[2] = new Question("Q 3 - What is JRE?","JRE is a java based GUI application.","JRE is an implementation of the Java Virtual Machine which executes Java programs.","JRE is an application development framework.","None of the above.", new Answer("JRE is an implementation of the Java Virtual Machine which executes Java programs."));
        questions[3] = new Question("Q 4 - Which method must be implemented by all threads?"," wait()","start()","stop()","run()", new Answer("run()"));
        questions[4] = new Question("Q 5 - Which of the following is not a Java features?","Dynamic","Architecture Neutral","Use of pointers","Object oriented", new Answer("Use of pointers"));

        int countTotal = 0;
        int countRight = 0;
        int countWrong = 0;

        for(Question q: questions)
        {
            System.out.println(q.getQuestion());
            System.out.println("A : " +q.getOption1());
            System.out.println("B : " +q.getOption2());
            System.out.println("C : " +q.getOption3());
            System.out.println("D : " +q.getOption4());

            String answer = "";

            char ans;
            System.out.println("Enter your answer");
            @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
            ans = scan.next().charAt(0);
          //if((ans >= 65 && ans <= 68)||(ans >= 97 && ans <= 100))
           
            switch(ans)
            {	case 'a' :
                case 'A' :
                    answer = q.getOption1();
                    break;
                case 'B':
                case 'b':
                    answer = q.getOption2();
                    break;
                case 'C':
                case 'c':
                    answer = q.getOption3();
                    break;
                case 'D':
                case 'd':
                    answer = q.getOption4();
                    break;
                default :
                	System.out.println("Invalid choice");
                	break;
                
            }
           
          
            
            
            System.out.println("Your answer : " + answer );
            if(answer.equals(q.getAnswer().getAnswer()))
            {
                System.out.println("------------------------------------------------------");
                System.out.println("                  Correct Answer                      ");
                System.out.println("------------------------------------------------------");
                countRight++;
            }
            else
            {
                System.out.println("------------------------------------------------------");
                System.out.println("                  Wrong Answer                      ");
                System.out.println("------------------------------------------------------");
                countWrong++;
            }
            System.out.println("============================================================================================");
            countTotal++;
          
           
           
        }
        
        
        Result result = new Result(countTotal,countRight,countWrong);
        result.showResult();
    }
}

class Question
{

    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    Answer answer;

    public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
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
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
    }

    public void showResult() {
        System.out.println("Your results!");
        System.out.println("Total Questions " + totalQuestions);
        System.out.println("Number of correct answers " + correctAnswers);
        System.out.println("Number of wrong answers " + wrongAnswers);
        System.out.println("Percentage " + showPercentage(correctAnswers,totalQuestions));
        System.out.println("Your performance " + showPerformance(showPercentage(correctAnswers,totalQuestions)));

    }

    
    public double showPercentage(int correctAnswers, int totalQuestions) {
        //System.out.println(correctAnswers + " " + totalQuestions);
        return (double) (correctAnswers / (double)totalQuestions) * 100 ;
    }

   
    public String showPerformance(double percentage) {
        String performance = "";

        if(percentage > 50)
        {
            performance = "Good";
        }
        else if(percentage <= 50)
        {
            performance = "Poor";
        }

        return performance;

    }
}