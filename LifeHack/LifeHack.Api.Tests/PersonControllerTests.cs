using LifeHack.Api.Controllers;
using LifeHack.Domain.Models;
using Microsoft.Extensions.Configuration;
using Moq;
using NUnit.Framework;
using System.Net.Http;

namespace Tests
{
    public class GoalControllerTests
    {
        [Test]
        public void PersonPostFails()
        {
            var mockFactory = new Mock<IHttpClientFactory>();
            var mockConfig = new Mock<IConfiguration>();
            var mockSection = new Mock<IConfigurationSection>();
            
            mockConfig.Setup(cfg => cfg.GetSection("LifeHackData")).Returns(mockSection.Object);
            mockSection.Setup(cfg => cfg.GetSection("Endpoint")).Returns(mockSection.Object);
            var mockController = new Mock<GoalsController>(mockFactory.Object, mockConfig.Object);
            mockController.Setup(ctr => ctr.Get()).ReturnsAsync(new Goal() {Id = 1});
            var controller = mockController.Object;

            var result = controller.Get().Result;

            Assert.IsTrue(result.Id == 1);
        }
    }
}