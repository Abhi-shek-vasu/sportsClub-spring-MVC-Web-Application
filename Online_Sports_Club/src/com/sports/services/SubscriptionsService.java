package com.sports.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sports.daos.SubscriptionsDao;
import com.sports.entities.Subscriptions;

@Service
public class SubscriptionsService
{
	@Autowired
	SubscriptionsDao subscriptionDaoRef;
	
	public int addSubscriptions(Subscriptions sub)
	{
		return subscriptionDaoRef.addSubscription(sub);
	}
	public List<Subscriptions> getSubscriptionForSport(int id)
	{
		return subscriptionDaoRef.getSubscriptionsForGivenSport(id);
	}
	public List<Subscriptions> GetEndingSubscriptions()
	{
		return subscriptionDaoRef.GetEndingSubscriptions();
	}
	
}
