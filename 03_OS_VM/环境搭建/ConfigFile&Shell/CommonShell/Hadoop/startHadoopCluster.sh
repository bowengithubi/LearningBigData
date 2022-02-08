#!/bin/bash

# 启动Hadoop集群(HDFS+Yarn)

# 前提：
# 1、集群之间需要配置ssh免密登录
# 2、网络名称已经修改，并且配置好host解析

echo "==========     启动hdfs     =========="
ssh hadoop102 "/opt/module/hadoop/sbin/start-dfs.sh"

echo "==========     启动yarn     =========="
ssh hadoop103 "/opt/module/hadoop/sbin/start-yarn.sh"

echo "==========     启动timeLineServer     =========="
ssh hadoop103 "yarn --daemon start timelineserver"

echo "==========     启动historyServer     =========="
ssh hadoop102 "mapred --daemon start historyserver"

echo "==========     启动结果     =========="
ssh hadoop102 "jpsall"
