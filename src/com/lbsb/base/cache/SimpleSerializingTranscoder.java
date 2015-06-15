package com.lbsb.base.cache;

import net.spy.memcached.transcoders.SerializingTranscoder;

public class SimpleSerializingTranscoder extends SerializingTranscoder {

	@Override
	protected Object deserialize(byte[] arg0) {
		// TODO Auto-generated method stub
		return super.deserialize(arg0);
	}

	@Override
	protected byte[] serialize(Object arg0) {
		// TODO Auto-generated method stub
		return super.serialize(arg0);
	}
	
	
}
