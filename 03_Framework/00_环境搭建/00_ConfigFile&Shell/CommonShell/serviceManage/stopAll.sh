#!/bin/bash

# 停止全部大数据相关服务

# 前提：
# 1、集群之间需要配置ssh免密登录
# 2、网络名称已经修改，并且配置好host解析

echo "==========     停止Phoenix QueryServer  =========="
ssh hadoop102 "/opt/module/phoenix/bin/queryserver.py stop"

echo "==========     停止Hbase集群     =========="
ssh hadoop103 "/opt/module/hbase-2.0.5/bin/stop-hbase.sh"

echo "==========     停止Kafka集群     =========="
ssh hadoop102 "/opt/module/serviceManage/stopKafkaCluster.sh"

echo "==========     停止Hive     =========="
ssh hadoop102 "/opt/module/serviceManage/hive.sh stop"

echo "==========     停止Hadoop HA     =========="
ssh hadoop102 "/opt/module/serviceManage/stopHBase.sh"

echo "==========     停止Azkaban集群     =========="
ssh hadoop102 "/opt/module/serviceManage/stopAzkaban.sh"

echo "==========     项目停止结果     =========="
ssh hadoop102 "/opt/module/serviceManage/jpsall"