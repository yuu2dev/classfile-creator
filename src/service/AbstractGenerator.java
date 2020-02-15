package service;

import config.Env;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

/**
 * @author Yuu2
 * updated 2020.02.15
 */
public interface AbstractGenerator extends AutoCloseable, Serializable {

  /**
   * 템플릿 세팅
   */
  public abstract void setTemplate(String fileName);
  /**
   * 모델 세팅
   */
  public abstract void addModel(String name, Object object);

  /**
   * 템플릿 불러오기
   */
  public default String read(String template) {

    String line = null;

    try(this) {

      BufferedReader reader = new BufferedReader(new FileReader(Env.TEMPLATE_PATH + "/" + template));

      line = reader.readLine();

    } catch(Exception e) {
      e.printStackTrace();
    }
    return line;
  }

  public abstract void write();
}