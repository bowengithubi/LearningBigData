#!/bin/bash

# 关闭Hadoop集群(HDFS+Yarn+Zookeeper)

# 前提：
# 1、集群之间需要配置ssh免密登录
# 2、网络名称已经修改，并且配置好host解析

echo "==========     停止HadoopHA集群     =========="
ssh hadoop102 "/opt/module/hadoop-3.1.3/sbin/stop-all.sh"

echo "==========     停止timeLineServer     =========="
ssh hadoop103 "yarn --daemon stop timelineserver"

echo "==========     停止historyServer     =========="
ssh hadoop102 "mapred --daemon stop historyserver"
