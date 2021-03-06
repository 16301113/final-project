package com.sports.yue.UI.UI.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.sports.yue.R;
import com.sports.yue.UI.UI.models.Group;
import com.sports.yue.UI.UI.models.Users;

public class GroupAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Group> list;


    public GroupAdapter(Context context, List<Group> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        GroupHolder holder;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_group, null);
            holder = new GroupHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (GroupHolder) convertView.getTag();
        }
        //设置数据
        Group group = getGroup(groupPosition);
        holder.groupName.setText(group.groupName);
        String settext = group.getOnlineCount()+"/"+getChildrenCount(groupPosition);
        holder.groupOnline.setText(settext);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        ChildHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child, null);
            holder = new ChildHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ChildHolder) convertView.getTag();
        }
////        //设置数据
        Users user = getGroup(groupPosition).getChild(childPosition);
        holder.img.setImageResource(user.getImgId());
        holder.RoomName.setText(user.getRoomName());
        holder.Type.setText(user.getType());
        holder.Member.setText(user.getMember());
        holder.Location.setText(user.getLocation());
        return convertView;
    }

    class GroupHolder{
        TextView groupName;
        TextView groupOnline;

        private GroupHolder(View convertView){
            groupName = (TextView) convertView.findViewById(R.id.groupName);
            groupOnline = (TextView) convertView.findViewById(R.id.groupOnline);
        }
    }
    class ChildHolder {
        ImageView img;
        TextView RoomName;
        TextView Type;
        TextView Member;
        TextView Location;

        private ChildHolder(View convertView) {
            img = (ImageView) convertView.findViewById(R.id.img);
            RoomName = (TextView) convertView.findViewById(R.id.RoomName);
            Type = (TextView) convertView.findViewById(R.id.Type);
            Member = (TextView) convertView.findViewById(R.id.Member);
            Location = (TextView) convertView.findViewById(R.id.Location);
        }
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getChildCount();
    }

    @Override
    public Group getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Users getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getChild(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}