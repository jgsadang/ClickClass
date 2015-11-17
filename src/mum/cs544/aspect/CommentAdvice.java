package mum.cs544.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import mum.cs544.domain.Comment;

@Aspect
@Component
public class CommentAdvice {
	@Before("execution(* mum.cs544.serviceImpl.CommentServiceImpl.save(..))")
	public void tracebeforemethod(JoinPoint joinpoint) {
		System.out.println("before execution of method " + joinpoint.getSignature().getName());
		Object[] object = joinpoint.getArgs();
		Comment comment = (Comment) object[0];
		String text = comment.getText();
		text = replaceInvalidWords(text);
		comment.setText(text);
	}
	
	public String replaceInvalidWords(String text) {
		text = text.replaceAll("<", "&lt;");
		text = text.replaceAll(">", "&gt;");
		text = text.replaceAll("(?i)fuck", "****");
		text = text.replaceAll("(?i)shit", "****");
		text = text.replaceAll("(?i)damn", "****");
		text = text.replaceAll("(?i)crap", "****");
		text = text.replaceAll("(?i)bitch", "****");
		System.out.println(text);
		return text;
	}
}