package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

/* DAO を使って DBアクセスしていたコードから、サービスBeanを使ってアクセスする形に変更する */
@Service
public class MyDataService {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<MyData> getAll() {
		@SuppressWarnings("unchecked")
		List<MyData> resultList = (List<MyData>)entityManager.createQuery("from MyData").getResultList();
		return resultList;
	}
	
	public MyData get(int num) {
		return (MyData)entityManager.createQuery("from MyData where id = " + num).getSingleResult();
	}
	
	public List<MyData> find(String fstr) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).where(builder.equal(root.get("name"), fstr));
		List<MyData> list = null;
		list = (List<MyData>) entityManager.createQuery(query).getResultList();
		return list;
	}
}
