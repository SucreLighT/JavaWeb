package cn.sucre.test;

import cn.sucre.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;


/**
 * @description:
 * @author: sucre
 * @date: 2020/07/22
 * @time: 18:43
 */
public class JacksonTest {

	public static void main(String[] args) throws JsonProcessingException {
		Person p = new Person();
		p.setAge(23);
		p.setGender("男");
		p.setName("张三");
		p.setBirthday(new Date());

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(p);

		System.out.println(json);
	}
}
