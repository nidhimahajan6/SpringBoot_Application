package com.rev.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
	public class Quote {

	    private String type;
	    private Value value;
	  
	    private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		

		@Override
		public String toString() {
			return "Quote [type=" + type + ", value=" + value + ", id=" + id + ", title=" + title + ", key=" + key
					+ ", ip=" + ip + "]";
		}



		private String title;
	    private String key;
	    
	    public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		private String ip;

	    public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getTitle() {
			return title;
		}

	

		public void setTitle(String title) {
			this.title = title;
		}

		public Quote() {
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public Value getValue() {
	        return value;
	    }

	    public void setValue(Value value) {
	        this.value = value;
	    }

	}

