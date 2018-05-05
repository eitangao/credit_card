package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.command.UpdateUserCommand;
import com.xmx.credit_card.constant.CardStatus;
import com.xmx.credit_card.dao.UserMapper;
import com.xmx.credit_card.dto.BillDTO;
import com.xmx.credit_card.dto.CardDebt;
import com.xmx.credit_card.dto.PointDTO;
import com.xmx.credit_card.dto.PointDetail;
import com.xmx.credit_card.entity.Card;
import com.xmx.credit_card.entity.Transaction;
import com.xmx.credit_card.entity.User;
import com.xmx.credit_card.service.CardService;
import com.xmx.credit_card.service.GoodsService;
import com.xmx.credit_card.service.TransactionService;
import com.xmx.credit_card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CardService cardService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private GoodsService goodsService;

    @Override
    public boolean register(String account, String password) {
        if(userMapper.getUserIdByAccount(account)!=null)
            throw new RuntimeException("Account already exists");
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setCreateTime(LocalDateTime.now());
        userMapper.addUser(user);
        return true;
    }

    @Override
    public boolean login(String account, String password) {
        if(userMapper.getUserByAccount(account).getPassword().equals(password))
            return true;
        else
            return false;
    }

    @Override
    public BillDTO getBillByAccount(String account) {
        BillDTO dto=new BillDTO();
        dto.setTotalDebt(new BigDecimal(6000).subtract(getAmountByAccount(account)));
        List<Card> cards=cardService.getCardListByCondition(account,null,CardStatus.ACTIVE);
        List<CardDebt> list=new ArrayList<>();
        for (Card card : cards) {
            CardDebt cardDebt=new CardDebt();
            cardDebt.setCardNumber(card.getCardNumber());
            cardDebt.setCardType(card.getCardType());
            switch(card.getCardType()){
                case BABY_GROWUP:
                    cardDebt.setCardDebt(new BigDecimal(2000).subtract(card.getCardAmount()));
                    break;
                case COMMERICAL:
                    cardDebt.setCardDebt(new BigDecimal(3000).subtract(card.getCardAmount()));
                    break;
                case GLOBAL_TRAVEL:
                    cardDebt.setCardDebt(new BigDecimal(4000).subtract(card.getCardAmount()));
                    break;
                case CHANGLONG:
                    cardDebt.setCardDebt(new BigDecimal(5000).subtract(card.getCardAmount()));
                    break;
                default:
                    cardDebt.setCardDebt(new BigDecimal(0));
            }
            list.add(cardDebt);
        }
        dto.setCardDebt(list);
        return dto;
    }

    @Override
    public PointDTO getPointByAccount(String account) {
        PointDTO dto=new PointDTO();
        dto.setTotalPoint(getUserByAccount(account).getPoint());
        List<Transaction> transactions=transactionService.getTransactionListByAccount(account);
        List<PointDetail> pointDetails=new ArrayList<>();
        for (Transaction transaction : transactions) {
            PointDetail detail=new PointDetail();
            detail.setProductId(transaction.getProduct());
            detail.setProductName(goodsService.findGoodsById(transaction.getProduct()).getName());
            detail.setPoint(transaction.getPoint());
            detail.setCreateTIme(transaction.getCreateTime());
            pointDetails.add(detail);
        }
        dto.setPointDetails(pointDetails);
        return dto;
    }

    @Override
    public void updateUserInfo(UpdateUserCommand updateUserCommand) {
        User user=new User();
        user.setId(updateUserCommand.getId());
        user.setUserName(updateUserCommand.getUserName());
        user.setPassword(updateUserCommand.getPassword());
        user.setIdCard(updateUserCommand.getIdCard());
        user.setIdPicture(updateUserCommand.getIdPicture());
        userMapper.updateUserInfo(user);
    }

    @Override
    public void updatePoint(String account, Integer point) {
        userMapper.updatePoint(account,point);
    }

    @Override
    public void updateAmount(String account, BigDecimal amount) {
        userMapper.updateAmount(account,amount);
    }

    @Override
    public BigDecimal getAmountByAccount(String account) {
        return userMapper.getAmountByAccount(account);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void frozeUser(String account) {
        userMapper.frozeAccount(account);
    }

    @Transactional
    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public Long getUserIdByAccount(String account) {
        return userMapper.getUserIdByAccount(account);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }
}
