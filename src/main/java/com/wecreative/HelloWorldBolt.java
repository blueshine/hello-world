package com.wecreative;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class HelloWorldBolt extends BaseRichBolt {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3674239111600148452L;
	
	private int myCount = 0;
	
	@Override
	public void execute(Tuple input) {
		String test = input.getStringByField("sentence");
		if (test == "Hello World") {
			myCount++;
			System.out.println("Found a Hello World! My Count is now: " + Integer.toString(myCount));
		}
	}
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("myCount"));
	}
	
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		
	}

}
