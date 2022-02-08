#!/bin/bash

# 在整个集群的每太机器，执行相同的命令

# 前提：
# 1、集群之间需要配置ssh免密登录
# 2、网络名称已经修改，并且配置好host解析

for i in hadoop102 hadoop103 hadoop104
do
	echo "========    $i    ========"
	ssh $i "$*"
done