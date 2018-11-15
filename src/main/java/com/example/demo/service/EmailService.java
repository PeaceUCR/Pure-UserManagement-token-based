package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    @Qualifier("serviceMailSender")
    private JavaMailSender javaMailSender;

    public void sendWelcomeEmail(User user){
        //https://stackoverflow.com/questions/49313440/mimemessagehelper-spring-boot-to-send-email
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED, "UTF-8");

            helper.setSubject("Welcome "+user.getUsername()+"!");
            helper.setTo(user.getEmail());
            helper.setFrom("Test Message<peacetestmsg@gmail.com>");

            helper.setText("Greetings!(from plain text)", "<center>\n" +
                    "    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"bodyTable\">\n" +
                    "      <tr>\n" +
                    "        <td align=\"center\" valign=\"top\" id=\"bodyCell\">\n" +
                    "          <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                    "            <tr>\n" +
                    "              <td align=\"center\" valign=\"top\" id=\"templatePreheader\">\n" +
                    "\n" +
                    "                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" \n" +
                    "                style=\" justify-content: center;\">\n" +
                    "                  <tr>\n" +
                    "                    <td valign=\"top\" >\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  style=\"min-width:100%;\">\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td valign=\"top\" style=\"padding:9px\" >\n" +
                    "                              <table align=\"left\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  style=\"min-width:100%;\">\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td  valign=\"top\" style=\"padding-right: 9px; padding-left: 9px; padding-top: 0; padding-bottom: 0; text-align:center;\">\n" +
                    "                                      <img align=\"center\" alt=\"\" src=\"https://gallery.mailchimp.com/6d5e686af3a776f67a79d56e6/images/99cf80c1-e13e-4d11-b362-99f2353760be.png\" width=\"564\" style=\"max-width:1169px; padding-bottom: 0; display: inline !important; vertical-align: bottom;\" >\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                    </td>\n" +
                    "                  </tr>\n" +
                    "                </table>\n" +
                    "              </td>\n" +
                    "            </tr>\n" +
                    "            <tr>\n" +
                    "              <td align=\"center\" valign=\"top\" id=\"templateHeader\">\n" +
                    "\n" +
                    "                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"justify-content: center;\">\n" +
                    "                  <tr>\n" +
                    "                    <td valign=\"top\" >\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  style=\"min-width:100%;\">\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td valign=\"top\" >\n" +
                    "                              <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\" >\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td valign=\"top\" style=\"padding: 9px 18px;color: #1E2945;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;text-align: left;\">\n" +
                    "                                      <p style=\"line-height: 150%;color: #1E2945;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;text-align: left;\"><strong>Hi "+user.getUsername()+", welcome on board!</strong>\n" +
                    "                                        <br>\n" +
                    "                                        <br>You'll be the first to know!\n" +
                    "                                        <br>\n" +
                    "                                        <br>This app is going to be awesome and it will change your experience.\n" +
                    "                                        <br>&nbsp;</p>\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td  valign=\"top\" style=\"padding:9px;\">\n" +
                    "                              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  width=\"100%\">\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td valign=\"top\"  style=\"padding:0 9px; flex-wrap: wrap ;justify-content: center; flex-direction: row;\">\n" +
                    "                                      <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td  valign=\"top\">\n" +
                    "                                              <img alt=\"\" src=\"https://gallery.mailchimp.com/6d5e686af3a776f67a79d56e6/images/cb8921b8-15d6-4658-8a6e-5dac7f4ad2d6.gif\" width=\"264\" style=\"max-width:340px;\" >\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                      <table  align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td valign=\"top\" style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\">\n" +
                    "                                              <p style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\">You will have full control of your animations, at anytime!</p>\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td valign=\"top\" style=\"padding:9px;\">\n" +
                    "                              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td valign=\"top\"  style=\"padding:0 9px; flex-wrap: wrap ;justify-content: center; flex-direction: row-reverse;\">\n" +
                    "                                      <table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td  valign=\"top\">\n" +
                    "                                              <img alt=\"\" src=\"https://gallery.mailchimp.com/6d5e686af3a776f67a79d56e6/images/32e57b08-f048-4a8f-b6bd-bcd5b8cc2eaf.gif\" width=\"264\" style=\"max-width:340px;\" >\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                      <table  align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td valign=\"top\"  style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\">\n" +
                    "                                              <p style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\"><span >Realtime feedback, creating animations is fun!</span>\n" +
                    "                                              </p>\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td  valign=\"top\" style=\"padding:9px;\">\n" +
                    "                              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  width=\"100%\">\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td valign=\"top\"  style=\"padding:0 9px; flex-wrap: wrap ;justify-content: center; flex-direction:row\">\n" +
                    "                                      <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td  valign=\"top\">\n" +
                    "                                              <img alt=\"\" src=\"https://gallery.mailchimp.com/6d5e686af3a776f67a79d56e6/images/1db61e28-9379-4773-9a94-3c79ef1152dd.gif\" width=\"264\" style=\"max-width:340px;\" >\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                      <table  align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td valign=\"top\"  style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\">\n" +
                    "                                              <p style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\"><span >It's easy to use, everybody should be able to create amazing animations!</span>\n" +
                    "                                              </p>\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td  valign=\"top\" style=\"padding:9px;\">\n" +
                    "                              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  width=\"100%\">\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td valign=\"top\"  style=\"padding:0 9px; flex-wrap: wrap ;justify-content: center; flex-direction: row-reverse;\">\n" +
                    "                                      <table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td  valign=\"top\">\n" +
                    "                                              <img alt=\"\" src=\"https://gallery.mailchimp.com/6d5e686af3a776f67a79d56e6/images/ac631a91-09ac-4f6f-b994-95dcbde08741.gif\" width=\"264\" style=\"max-width:340px;\" >\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                      <table  align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td valign=\"top\"  style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\">\n" +
                    "                                              <p style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\"><span >Everybody wants their animation to run smoothly, therefore this app runs on GPU whenever possible.</span>\n" +
                    "                                              </p>\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td  valign=\"top\" style=\"padding:0 9px; flex-wrap: wrap ;justify-content: center; flex-direction: row;\">\n" +
                    "                              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  width=\"100%\">\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td valign=\"top\"  style=\"padding:0 9px; flex-wrap: wrap ;justify-content: center; flex-direction: row;\">\n" +
                    "                                      <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td  valign=\"top\">\n" +
                    "                                              <img alt=\"\" src=\"https://gallery.mailchimp.com/6d5e686af3a776f67a79d56e6/images/75b2c7e5-b914-4bfc-abd1-18e3a3c159a8.gif\" width=\"264\" style=\"max-width:340px;\" >\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                      <table  align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"264\">\n" +
                    "                                        <tbody>\n" +
                    "                                          <tr>\n" +
                    "                                            <td valign=\"top\"  style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\">\n" +
                    "                                              <p style=\"color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\"><span >No coding required. Build prototypes or production ready animations in no time!\n" +
                    "<br>You can add custom javascript for even more control.</span>\n" +
                    "                                              </p>\n" +
                    "                                            </td>\n" +
                    "                                          </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                      </table>\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td valign=\"top\" style=\"padding:9px;\">\n" +
                    "                              <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  width=\"false\">\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td  valign=\"top\" style=\"padding: 0px 9px;color: #1F2A44;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\" width=\"564\">\n" +
                    "                                      <br> <span style=\"line-height:20.8px\">Please sit back and wait while I do all the work and build something great for you!</span>\n" +
                    "\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                  <tr>\n" +
                    "                                    <td  align=\"center\" valign=\"top\" style=\"padding:9px 9px 0 9px;\">\n" +
                    "                                      <img alt=\"\" src=\"https://gallery.mailchimp.com/6d5e686af3a776f67a79d56e6/images/6f25dcf1-ca58-47fe-b1a3-b53b200189e8.gif\" width=\"340\" style=\"max-width:340px;\" >\n" +
                    "                                    </td>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  style=\"min-width:100%;\">\n" +
                    "                        <tbody >\n" +
                    "                          <tr>\n" +
                    "                            <td valign=\"top\" >\n" +
                    "                              <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width:100%;\" >\n" +
                    "                                <tbody>\n" +
                    "                                  <tr>\n" +
                    "                                    <td valign=\"top\"  style=\"padding: 9px 18px;color: #1E2945;font-family: 'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace;font-size: 18px;font-style: normal;font-weight: normal;line-height: 150%;\">I hope to see you soon,\n" +
                    "                                      <br>\n" +
                    "                                      <br>\n" +
                    "                                      <br>\n" +
                    "                                      <br>\n" +
                    "                                      Greetings from developer:\n" +
                    "                                      <br>\n" +
                    "                                      <a href=\"https://www.linkedin.com/in/ping-adam-he-peace1991/\">Ping He(Peace/Adam)</a>\n" +
                    "                                  </tr>\n" +
                    "                                </tbody>\n" +
                    "                              </table>\n" +
                    "                            </td>\n" +
                    "                          </tr>\n" +
                    "                        </tbody>\n" +
                    "                      </table>\n" +
                    "                    </td>\n" +
                    "                  </tr>\n" +
                    "                </table>\n" +
                    "              </td>\n" +
                    "            </tr>\n" +
                    "  </center>\n" +
                    "\n" +
                    "\n");
            javaMailSender.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }

    }

    public void sendResetPassword(User user,String token){
        //https://stackoverflow.com/questions/49313440/mimemessagehelper-spring-boot-to-send-email
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED, "UTF-8");

            helper.setSubject("Reset Password!");
            helper.setTo(user.getEmail());
            helper.setFrom("Test Message<peacetestmsg@gmail.com>");

            helper.setText("Reset Password.", "<center>\n" +
                    "    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" id=\"bodyTable\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust:\n" +
                    " 100%; background-color: #fed149; height: 100%; margin: 0; padding: 0; width:\n" +
                    " 100%\" width=\"100%\">\n" +
                    "      <tr>\n" +
                    "        <td align=\"center\" id=\"bodyCell\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; border-top: 0;\n" +
                    " height: 100%; margin: 0; padding: 0; width: 100%\" valign=\"top\">\n" +
                    "          <!-- BEGIN TEMPLATE // -->\n" +
                    "          <!--[if gte mso 9]>\n" +
                    "              <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">\n" +
                    "                <tr>\n" +
                    "                  <td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">\n" +
                    "                  <![endif]-->\n" +
                    "          <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"templateContainer\" style=\"border-collapse: collapse; mso-table-lspace: 0; mso-table-rspace: 0;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; max-width:\n" +
                    " 600px; border: 0\" width=\"100%\">\n" +
                    "            <tr>\n" +
                    "              <td id=\"templatePreheader\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; background-color: #fed149;\n" +
                    " border-top: 0; border-bottom: 0; padding-top: 16px; padding-bottom: 8px\" valign=\"top\">\n" +
                    "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextBlock\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                    " min-width:100%;\" width=\"100%\">\n" +
                    "                  <tbody class=\"mcnTextBlockOuter\">\n" +
                    "                    <tr>\n" +
                    "                      <td class=\"mcnTextBlockInner\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%\" valign=\"top\">\n" +
                    "                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextContentContainer\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust:\n" +
                    " 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                          <tbody>\n" +
                    "                            <tr>\n" +
                    "                              <td class=\"mcnTextContent\" style='mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; word-break: break-word;\n" +
                    " color: #2a2a2a; font-family: \"Asap\", Helvetica, sans-serif; font-size: 12px;\n" +
                    " line-height: 150%; text-align: left; padding-top:9px; padding-right: 18px;\n" +
                    " padding-bottom: 9px; padding-left: 18px;' valign=\"top\">\n" +
                    "                                <a  style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; color: #2a2a2a;\n" +
                    " font-weight: normal; text-decoration: none\" target=\"_blank\" title=\"Lingo is the\n" +
                    " best way to organize, share and use all your visual assets in one place -\n" +
                    " all on your desktop.\">\n" +
                    "                                </a>\n" +
                    "                              </td>\n" +
                    "                            </tr>\n" +
                    "                          </tbody>\n" +
                    "                        </table>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </tbody>\n" +
                    "                </table>\n" +
                    "              </td>\n" +
                    "            </tr>\n" +
                    "            <tr>\n" +
                    "              <td id=\"templateHeader\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; background-color: #f7f7ff;\n" +
                    " border-top: 0; border-bottom: 0; padding-top: 16px; padding-bottom: 0\" valign=\"top\">\n" +
                    "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnImageBlock\" style=\"border-collapse: collapse; mso-table-lspace: 0; mso-table-rspace: 0;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                    " min-width:100%;\" width=\"100%\">\n" +
                    "                  <tbody class=\"mcnImageBlockOuter\">\n" +
                    "                    <tr>\n" +
                    "                      <td class=\"mcnImageBlockInner\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding:0px\" valign=\"top\">\n" +
                    "                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnImageContentContainer\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust:\n" +
                    " 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                          <tbody>\n" +
                    "                            <tr>\n" +
                    "                              <td class=\"mcnImageContent\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-right: 0px;\n" +
                    " padding-left: 0px; padding-top: 0; padding-bottom: 0; text-align:center;\" valign=\"top\">\n" +
                    "                                  <a class=\"\"  style=\"mso-line-height-rule:\n" +
                    " exactly; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; color:\n" +
                    " #f57153; font-weight: normal; text-decoration: none\" target=\"_blank\" title=\"\">\n" +
                    "                                    <img align=\"center\" alt=\"Forgot your password?\" class=\"mcnImage\" src=\"https://static.lingoapp.com/assets/images/email/il-password-reset@2x.png\" style=\"-ms-interpolation-mode: bicubic; border: 0; height: auto; outline: none;\n" +
                    " text-decoration: none; vertical-align: bottom; max-width:1200px; padding-bottom:\n" +
                    " 0; display: inline !important; vertical-align: bottom;\" width=\"600\"></img>\n" +
                    "                                  </a>\n" +
                    "                                </a>\n" +
                    "                              </td>\n" +
                    "                            </tr>\n" +
                    "                          </tbody>\n" +
                    "                        </table>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </tbody>\n" +
                    "                </table>\n" +
                    "              </td>\n" +
                    "            </tr>\n" +
                    "            <tr>\n" +
                    "              <td id=\"templateBody\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; background-color: #f7f7ff;\n" +
                    " border-top: 0; border-bottom: 0; padding-top: 0; padding-bottom: 0\" valign=\"top\">\n" +
                    "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextBlock\" style=\"border-collapse: collapse; mso-table-lspace: 0; mso-table-rspace: 0;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                  <tbody class=\"mcnTextBlockOuter\">\n" +
                    "                    <tr>\n" +
                    "                      <td class=\"mcnTextBlockInner\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%\" valign=\"top\">\n" +
                    "                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextContentContainer\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust:\n" +
                    " 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                          <tbody>\n" +
                    "                            <tr>\n" +
                    "                              <td class=\"mcnTextContent\" style='mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; word-break: break-word;\n" +
                    " color: #2a2a2a; font-family: \"Asap\", Helvetica, sans-serif; font-size: 16px;\n" +
                    " line-height: 150%; text-align: center; padding-top:9px; padding-right: 18px;\n" +
                    " padding-bottom: 9px; padding-left: 18px;' valign=\"top\">\n" +
                    "\n" +
                    "                                <h1 class=\"null\" style='color: #2a2a2a; font-family: \"Asap\", Helvetica,\n" +
                    " sans-serif; font-size: 32px; font-style: normal; font-weight: bold; line-height:\n" +
                    " 125%; letter-spacing: 2px; text-align: center; display: block; margin: 0;\n" +
                    " padding: 0'><span style=\"text-transform:uppercase\">Forgot</span></h1>\n" +
                    "\n" +
                    "\n" +
                    "                                <h2 class=\"null\" style='color: #2a2a2a; font-family: \"Asap\", Helvetica,\n" +
                    " sans-serif; font-size: 24px; font-style: normal; font-weight: bold; line-height:\n" +
                    " 125%; letter-spacing: 1px; text-align: center; display: block; margin: 0;\n" +
                    " padding: 0'><span style=\"text-transform:uppercase\">your password?</span></h2>\n" +
                    "\n" +
                    "                              </td>\n" +
                    "                            </tr>\n" +
                    "                          </tbody>\n" +
                    "                        </table>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </tbody>\n" +
                    "                </table>\n" +
                    "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextBlock\" style=\"border-collapse: collapse; mso-table-lspace: 0; mso-table-rspace:\n" +
                    " 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                    " min-width:100%;\" width=\"100%\">\n" +
                    "                  <tbody class=\"mcnTextBlockOuter\">\n" +
                    "                    <tr>\n" +
                    "                      <td class=\"mcnTextBlockInner\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%\" valign=\"top\">\n" +
                    "                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextContentContainer\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust:\n" +
                    " 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                          <tbody>\n" +
                    "                            <tr>\n" +
                    "                              <td class=\"mcnTextContent\" style='mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; word-break: break-word;\n" +
                    " color: #2a2a2a; font-family: \"Asap\", Helvetica, sans-serif; font-size: 16px;\n" +
                    " line-height: 150%; text-align: center; padding-top:9px; padding-right: 18px;\n" +
                    " padding-bottom: 9px; padding-left: 18px;' valign=\"top\">Not to worry, we got you! Let’s get you a new password.\n" +
                    "                                <br></br>\n" +
                    "                              </td>\n" +
                    "                            </tr>\n" +
                    "                          </tbody>\n" +
                    "                        </table>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </tbody>\n" +
                    "                </table>\n" +
                    "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnButtonBlock\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                    " min-width:100%;\" width=\"100%\">\n" +
                    "                  <tbody class=\"mcnButtonBlockOuter\">\n" +
                    "                    <tr>\n" +
                    "                      <td align=\"center\" class=\"mcnButtonBlockInner\" style=\"mso-line-height-rule:\n" +
                    " exactly; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                    " padding-top:18px; padding-right:18px; padding-bottom:18px; padding-left:18px;\" valign=\"top\">\n" +
                    "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnButtonBlock\" style=\"border-collapse: collapse; mso-table-lspace: 0; mso-table-rspace: 0;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                          <tbody class=\"mcnButtonBlockOuter\">\n" +
                    "                            <tr>\n" +
                    "                              <td align=\"center\" class=\"mcnButtonBlockInner\" style=\"mso-line-height-rule:\n" +
                    " exactly; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                    " padding-top:0; padding-right:18px; padding-bottom:18px; padding-left:18px;\" valign=\"top\">\n" +
                    "                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnButtonContentContainer\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                    " border-collapse: separate !important;border-radius: 48px;background-color:\n" +
                    " #F57153;\">\n" +
                    "                                  <tbody>\n" +
                    "                                    <tr>\n" +
                    "                                      <td align=\"center\" class=\"mcnButtonContent\" style=\"mso-line-height-rule:\n" +
                    " exactly; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                    " font-family: 'Asap', Helvetica, sans-serif; font-size: 16px; padding-top:24px;\n" +
                    " padding-right:48px; padding-bottom:24px; padding-left:48px;\" valign=\"middle\">\n" +
                    "                                        <a href=\"http://localhost:8080/changepassword?token="+token+"\" target=\"_blank\" >Reset password</a>\n" +
                    "                                      </td>\n" +
                    "                                    </tr>\n" +
                    "                                  </tbody>\n" +
                    "                                </table>\n" +
                    "                              </td>\n" +
                    "                            </tr>\n" +
                    "                          </tbody>\n" +
                    "                        </table>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </tbody>\n" +
                    "                </table>\n" +
                    "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnImageBlock\" style=\"border-collapse: collapse; mso-table-lspace: 0; mso-table-rspace: 0;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                  <tbody class=\"mcnImageBlockOuter\">\n" +
                    "                    <tr>\n" +
                    "                      <td class=\"mcnImageBlockInner\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding:0px\" valign=\"top\">\n" +
                    "                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnImageContentContainer\" style=\"border-collapse: collapse; mso-table-lspace: 0;\n" +
                    " mso-table-rspace: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust:\n" +
                    " 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                          <tbody>\n" +
                    "                            <tr>\n" +
                    "                              <td class=\"mcnImageContent\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-right: 0px;\n" +
                    " padding-left: 0px; padding-top: 0; padding-bottom: 0; text-align:center;\" valign=\"top\"></td>\n" +
                    "                            </tr>\n" +
                    "                          </tbody>\n" +
                    "                        </table>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </tbody>\n" +
                    "                </table>\n" +
                    "              </td>\n" +
                    "            </tr>\n" +
                    "            <tr>\n" +
                    "              <td id=\"templateFooter\" style=\"mso-line-height-rule: exactly;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; background-color: #fed149;\n" +
                    " border-top: 0; border-bottom: 0; padding-top: 8px; padding-bottom: 80px\" valign=\"top\">\n" +
                    "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextBlock\" style=\"border-collapse: collapse; mso-table-lspace: 0; mso-table-rspace: 0;\n" +
                    " -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; min-width:100%;\" width=\"100%\">\n" +
                    "                </table>\n" +
                    "              </td>\n" +
                    "            </tr>\n" +
                    "          </table>\n" +
                    "          <!--[if gte mso 9]>\n" +
                    "                  </td>\n" +
                    "                </tr>\n" +
                    "              </table>\n" +
                    "            <![endif]-->\n" +
                    "          <!-- // END TEMPLATE -->\n" +
                    "        </td>\n" +
                    "      </tr>\n" +
                    "    </table>\n" +
                    "  </center>\n");
            javaMailSender.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
