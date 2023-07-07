<template>
  <div>
    <!-- 搜索栏 -->
    <el-card id="search">
      <el-row>
        <el-col :span="20">
          <el-input v-model="searchModel.taskName" placeholder="站点名" clearable></el-input>
          <el-button @click="getUserList" type="primary" round icon="el-icon-search">查询</el-button>
        </el-col>
        <el-col :span="4" align="right">
          <el-button @click="openEditUI(null)" type="primary" icon="el-icon-plus" circle></el-button>
        </el-col>
      </el-row>
    </el-card>

    <!-- 结果列表 -->
    <el-card>
      <el-table :data="userList" stripe style="width: 100%">
        <el-table-column label="#" width="80">
          <template slot-scope="scope">
            <!-- (pageNo-1) * pageSize + index + 1 -->
            {{
              (searchModel.pageNo - 1) * searchModel.pageSize + scope.$index + 1
            }}
          </template>
        </el-table-column>
        <el-table-column prop="taskID" label="ID" width="180">
        </el-table-column>
        <el-table-column prop="taskName" label="站点名" width="180">
        </el-table-column>
        <el-table-column prop="indicatorID" label="指标id" width="180">
        </el-table-column>
        <!-- <el-table-column prop="indicatorName" label="指标" width="150">
        </el-table-column> -->
        <el-table-column prop="indicatorValue" label="指标值" width="180">
        </el-table-column>
        <!-- <el-table-column prop="indicatorUnit" label="指标单位" width="180">
        </el-table-column> -->
        <el-table-column prop="indicatorTime" label="监测时间" width="200">
        </el-table-column>
        <el-table-column label="操作" width="180">
          <template slot-scope="scope">
            <el-button @click="openEditUI(scope.row.taskID)" type="primary" icon="el-icon-edit" size="mini"
              circle></el-button>
            <el-button @click="deleteUser(scope.row)" type="danger" icon="el-icon-delete" size="mini" circle></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 分页组件 -->
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
      :current-page="searchModel.pageNo" :page-sizes="[5, 10, 20, 50]" :page-size="searchModel.pageSize"
      layout="total, sizes, prev, pager, next, jumper" :total="total">
    </el-pagination>

    <!-- 用户信息编辑对话框 -->
    <el-dialog @close="clearForm" :title="title" :visible.sync="dialogFormVisible">
      <el-form :model="userForm" ref="userFormRef" :rules="rules">
        <el-form-item label="站点名" prop="taskName" :label-width="formLabelWidth">
          <el-input v-model="userForm.taskName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="指标" :label-width="formLabelWidth">
          <!-- 复选框 -->
          <el-radio-group style="width: 85%" v-model="userForm.indicatorID">
            <el-radio v-for="role in roleList" :label="role.indicatorID" :key="role.indicatorID">{{
              role.indicatorName }}({{ role.indicatorUnit }})</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="指标值" prop="indicatorValue" :label-width="formLabelWidth">
          <el-input v-model="userForm.indicatorValue" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="监测时间" prop="indicatorTime" :label-width="formLabelWidth">
          <el-input v-model="userForm.indicatorTime" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveUser">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import userApi from "@/api/monitorManage";
import roleApi from "@/api/indicatorManage";
export default {
  data() {
    return {
      roleList: [],
      formLabelWidth: "130px",
      userForm: {
        indicatorID: 1
      },
      dialogFormVisible: false,
      title: "",
      total: 0,
      searchModel: {
        pageNo: 1,
        pageSize: 8,
      },
      userList: [],
      rules: {
        // username: [
        //   { required: true, message: "请输入用户名", trigger: "blur" },
        //   {
        //     min: 3,
        //     max: 50,
        //     message: "长度在 3 到 50 个字符",
        //     trigger: "blur",
        //   },
        // ],
        // password: [
        //   { required: true, message: "请输入登录初始密码", trigger: "blur" },
        //   {
        //     min: 6,
        //     max: 16,
        //     message: "长度在 6 到 16 个字符",
        //     trigger: "blur",
        //   },
        // ],
        // email: [
        //   { required: true, message: "请输入电子邮件", trigger: "blur" },
        //   { validator: checkEmail, trigger: "blur" },
        // ],
      },
      
    };
  },
  methods: {
    getAllRoleList() {
      roleApi.getAllRoleList().then(response => {
        console.log(response)
        this.roleList = response.data;
        console.log(this.roleList);
      });
    },
    deleteUser(user) {
      this.$confirm(`您确认删除${user.taskName + user.indicatorValue}的数据 ?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        console.log(user)
        userApi.deleteUserById(user.taskID).then(response => {
          this.$message({
            type: 'success',
            message: response.message
          });
          this.getUserList();
        });

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    saveUser() {
      // 触发表单验证
      this.$refs.userFormRef.validate((valid) => {
        if (valid) {
          // 提交请求给后台
          userApi.saveUser(this.userForm).then(response => {
            // 成功提示
            console.log(this.userForm)
            this.$message({
              message: response.message,
              type: 'success'
            });
            // 关闭对话框
            this.dialogFormVisible = false;
            // 刷新表格
            this.getUserList();
          });
        } else {
          console.log(this.userForm)

          console.log("error submit!!");
          return false;
        }
      });

    },
    clearForm() {
      this.userForm = {
        indicatorID: 1
      };
      this.$refs.userFormRef.clearValidate();
    },
    openEditUI(id) {
      if (id == null) {
        this.title = "新增数据";
      } else {
        this.title = "修改数据";
        // 根据id查询用户数据
        userApi.getUserById(id).then(response => {
          this.userForm = response.data;
          console.log(this.userForm)
        });
      }
      this.dialogFormVisible = true;
    },
    handleSizeChange(pageSize) {
      this.searchModel.pageSize = pageSize;
      this.getUserList();
    },
    handleCurrentChange(pageNo) {
      this.searchModel.pageNo = pageNo;
      this.getUserList();
    },
    getUserList() {
      userApi.getUserList(this.searchModel).then((response) => {
        let data = response.data.rows;
        console.log(data)
        data.map((item, index) => {
          const year = item.indicatorTime[0];
          const month = item.indicatorTime[1] - 1; // 月份从 0 开始，所以需要减去 1
          const day = item.indicatorTime[2];

          const date = new Date(year, month, day);
          item.indicatorTime = date.toISOString().slice(0, 10);
          // console.log(item.indicatorTime)
        })
        this.userList = response.data.rows;
        this.total = response.data.total;
        console.log(this.userList, response, this.userForm, this.roleList)
      });
    },
  },
  created() {
    this.getAllRoleList()
    this.getUserList()

  },
};
</script>

<style>
#search .el-input {
  width: 200px;
  margin-right: 10px;
}

.el-dialog .el-input {
  width: 85%;
}
</style>